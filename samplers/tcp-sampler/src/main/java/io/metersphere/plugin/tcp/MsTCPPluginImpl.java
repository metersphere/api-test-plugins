package io.metersphere.plugin.tcp;


import io.metersphere.plugin.api.spi.AbstractApiPlugin;

/**
 * @author jianxing
 */
public class MsTCPPluginImpl extends AbstractApiPlugin {

    public static final String MQTT_PLUGIN_NAME = "TCP";

    @Override
    public boolean isXpack() {
        return false;
    }

    @Override
    public String getName() {
        return MQTT_PLUGIN_NAME;
    }

    @Override
    public String getScriptDir() {
        return "https://ms-release.oss-cn-hangzhou.aliyuncs.com/plugin/tcp.png";
    }
}
