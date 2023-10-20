package io.metersphere.plugin.parallel;

import io.metersphere.plugin.api.spi.AbstractApiPlugin;

public class ParallelControllerPlugin extends AbstractApiPlugin {

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
