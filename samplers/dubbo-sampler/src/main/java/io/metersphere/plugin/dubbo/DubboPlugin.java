package io.metersphere.plugin.dubbo;


import io.metersphere.plugin.api.spi.AbstractApiPlugin;

/**
 * @author jianxing
 */
public class DubboPlugin extends AbstractApiPlugin {

    public static final String MQTT_PLUGIN_NAME = "dubbo";

    @Override
    public boolean isXpack() {
        return false;
    }

    @Override
    public String getName() {
        return MQTT_PLUGIN_NAME;
    }
}
