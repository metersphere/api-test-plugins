package io.metersphere.plugin.jdbc;


import io.metersphere.plugin.api.spi.AbstractProtocolPlugin;

/**
 * @author jianxing
 */
public class JDBCEntryPoint extends AbstractProtocolPlugin {

    public static final String JDBC = "jdbc";

    @Override
    public String getName() {
        return JDBC;
    }

    @Override
    public String getProtocol() {
        return JDBC;
    }
}
