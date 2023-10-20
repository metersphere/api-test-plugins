package io.metersphere.plugin.jdbc;


import io.metersphere.plugin.api.spi.AbstractApiPlugin;

/**
 * @author jianxing
 */
public class JDBCPlugin extends AbstractApiPlugin {

    public static final String MQTT_PLUGIN_NAME = "jdbc";

    @Override
    public boolean isXpack() {
        return false;
    }

    @Override
    public String getName() {
        return MQTT_PLUGIN_NAME;
    }
}
