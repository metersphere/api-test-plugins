package io.metersphere.plugin.dubbo;


import io.metersphere.plugin.api.spi.AbstractProtocolPlugin;

/**
 * @author jianxing
 */
public class DubboEntryPoint extends AbstractProtocolPlugin {

    public static final String DUBBO = "dubbo";

    @Override
    public boolean isXpack() {
        return false;
    }

    @Override
    public String getName() {
        return DUBBO;
    }

    @Override
    public String getProtocol() {
        return DUBBO;
    }
}
