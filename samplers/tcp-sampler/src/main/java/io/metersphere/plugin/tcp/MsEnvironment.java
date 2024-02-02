package io.metersphere.plugin.tcp;

import lombok.Data;

@Data
public class MsEnvironment {
    private String comments;
    private String classname;
    private String serverIp;
    private String port;
    private String connTimeout;
    private String resTimeout;
    private boolean reUseConnection = true;
    private boolean noDelay;
    private boolean closeConnection;
    private String soLinger;
    private String eolByte;
    private String username;
    private String password;
    private String request;

}
