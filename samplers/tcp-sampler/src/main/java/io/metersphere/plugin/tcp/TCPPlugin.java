package io.metersphere.plugin.tcp;


import io.metersphere.plugin.api.spi.AbstractApiPlugin;

/**
 * @author jianxing
 */
public class TCPPlugin extends AbstractApiPlugin {

    public static final String MQTT_PLUGIN_NAME = "tcp";

    @Override
    public boolean isXpack() {
        return false;
    }

    @Override
    public String getName() {
        return MQTT_PLUGIN_NAME;
    }
}
