package io.metersphere.plugin.tcp;

import io.metersphere.plugin.api.annotation.PluginSubType;
import io.metersphere.plugin.api.spi.AbstractMsTestElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@PluginSubType("MsTCPSampler")
public class MsTCPSampler extends AbstractMsTestElement {
    private String classname;
    private String server;
    private String port;
    private String connTimeout;
    private String timeout;
    private boolean reUseConnection = true;
    private boolean nodelay;
    private boolean closeConnection;
    private String soLinger;
    private String eolByte;
    private String username;
    private String password;
    private String request;
    private String encoding;
}
