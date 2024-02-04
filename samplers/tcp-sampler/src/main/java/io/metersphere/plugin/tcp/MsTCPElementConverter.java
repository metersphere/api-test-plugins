package io.metersphere.plugin.tcp;


import io.metersphere.plugin.api.constants.ElementProperty;
import io.metersphere.plugin.api.dto.ParameterConfig;
import io.metersphere.plugin.api.spi.AbstractJmeterElementConverter;
import io.metersphere.plugin.sdk.util.PluginLogUtils;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.tcp.sampler.MsTCPClientImpl;
import org.apache.jmeter.protocol.tcp.sampler.TCPSampler;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.ListedHashTree;

/**
 * TCP 协议脚本解析器
 */
public class MsTCPElementConverter extends AbstractJmeterElementConverter<MsTCPSampler> {
    @Override
    public void toHashTree(HashTree tree, MsTCPSampler element, ParameterConfig config) {
        if (!element.getEnable()) {
            PluginLogUtils.info("TCPSamplerProxy is disabled");
            return;
        }
        // 环境处理
        MsEnvironmentMapper.parse(config.getProtocolEnvConfig(element), element);

        final HashTree samplerHashTree = new ListedHashTree();
        samplerHashTree.add(tcpConfig(element));
        TCPSampler tcpSampler = tcpSampler(element);

        // TODO: 当前步骤唯一标识，很重要，结果和步骤匹配的关键
        tcpSampler.setProperty(ElementProperty.MS_RESOURCE_ID.name(), element.getResourceId());
        tcpSampler.setProperty(ElementProperty.MS_STEP_ID.name(), element.getStepId());
        tcpSampler.setProperty(ElementProperty.MS_REPORT_ID.name(), config.getReportId());
        tcpSampler.setProperty(ElementProperty.PROJECT_ID.name(), element.getProjectId());

        tree.set(tcpSampler, samplerHashTree);
        parseChild(samplerHashTree, element, config);
    }

    private TCPSampler tcpSampler(MsTCPSampler element) {
        TCPSampler tcpSampler = new TCPSampler();
        tcpSampler.setEnabled(true);
        tcpSampler.setName(element.getName());
        if (StringUtils.isEmpty(element.getName())) {
            tcpSampler.setName("TCPSampler");
        }

        tcpSampler.setProperty(TestElement.TEST_CLASS, TCPSampler.class.getName());
        tcpSampler.setProperty(TestElement.GUI_CLASS, SaveService.aliasToClass("TCPSamplerGui"));

        if (StringUtils.isEmpty(element.getClassname())) {
            tcpSampler.setClassname("TCPClientImpl");
        } else {
            tcpSampler.setClassname(element.getClassname());
        }
        // 自定义实现，值Encoding
        if (StringUtils.equals("TCPClientImpl", element.getClassname())) {
            tcpSampler.setClassname(MsTCPClientImpl.class.getCanonicalName());
        }
        tcpSampler.setCharset(CharEncoding.UTF_8);
        tcpSampler.setServer(element.getServerIp());
        tcpSampler.setPort(element.getPort());
        tcpSampler.setConnectTimeout(element.getConnTimeout());
        tcpSampler.setProperty(TCPSampler.RE_USE_CONNECTION, element.isReUseConnection());
        tcpSampler.setProperty(TCPSampler.NODELAY, element.isNoDelay());
        tcpSampler.setCloseConnection(String.valueOf(element.isCloseConnection()));
        tcpSampler.setSoLinger(element.getSoLinger());
        if (StringUtils.equalsIgnoreCase("LengthPrefixedBinaryTCPClientImpl", element.getClassname())) {
            element.setEolByte(null);
        } else {
            tcpSampler.setEolByte(element.getEolByte());
        }
        if (StringUtils.isNotEmpty(element.getResTimeout())) {
            tcpSampler.setTimeout(element.getResTimeout());
        }
        if (StringUtils.isNotEmpty(element.getConnTimeout())) {
            tcpSampler.setConnectTimeout(element.getConnTimeout());
        }
        String value = element.getRequest();
        tcpSampler.setRequestData(value);
        tcpSampler.setProperty(ConfigTestElement.USERNAME, element.getUsername());
        tcpSampler.setProperty(ConfigTestElement.PASSWORD, element.getPassword());

        return tcpSampler;
    }


    private ConfigTestElement tcpConfig(MsTCPSampler element) {
        ConfigTestElement configTestElement = new ConfigTestElement();
        configTestElement.setEnabled(true);
        configTestElement.setName(element.getName());
        configTestElement.setProperty(TestElement.TEST_CLASS, ConfigTestElement.class.getName());
        configTestElement.setProperty(TestElement.GUI_CLASS, SaveService.aliasToClass("TCPConfigGui"));
        if (!StringUtils.equals("TCPClientImpl", element.getClassname())) {
            configTestElement.setProperty(TCPSampler.CLASSNAME, element.getClassname());
        }
        configTestElement.setProperty(TCPSampler.SERVER, element.getServerIp());
        configTestElement.setProperty(TCPSampler.PORT, element.getPort());
        configTestElement.setProperty(TCPSampler.TIMEOUT_CONNECT, element.getConnTimeout());
        configTestElement.setProperty(TCPSampler.RE_USE_CONNECTION, element.isReUseConnection());
        configTestElement.setProperty(TCPSampler.NODELAY, element.isNoDelay());
        configTestElement.setProperty(TCPSampler.CLOSE_CONNECTION, element.isCloseConnection());
        configTestElement.setProperty(TCPSampler.SO_LINGER, element.getSoLinger());
        if (!StringUtils.equalsIgnoreCase("LengthPrefixedBinaryTCPClientImpl", element.getClassname())) {
            configTestElement.setProperty(TCPSampler.EOL_BYTE, element.getEolByte());
        }
        configTestElement.setProperty(TCPSampler.SO_LINGER, element.getSoLinger());
        configTestElement.setProperty(ConfigTestElement.USERNAME, element.getUsername());
        configTestElement.setProperty(ConfigTestElement.PASSWORD, element.getPassword());
        return configTestElement;
    }
}
