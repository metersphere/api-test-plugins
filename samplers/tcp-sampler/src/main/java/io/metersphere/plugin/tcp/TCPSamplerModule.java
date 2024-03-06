package io.metersphere.plugin.tcp;

import io.metersphere.plugin.api.annotation.PluginSubType;
import io.metersphere.plugin.api.spi.AbstractMsTestElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.pf4j.Extension;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@PluginSubType("TCPSamplerModule")
@Extension
public class TCPSamplerModule extends AbstractMsTestElement {
    private String comments;
    private String classname;
    private String serverIp;
    private String port;
    private String connTimeout;
    private String resTimeout;
    private List<String> reUseConnection;
    private List<String> noDelay;
    private List<String> closeConnection;
    private String soLinger;
    private String eolByte;
    private String username;
    private String password;
    private String content;
}
