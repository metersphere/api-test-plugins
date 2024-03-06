package io.metersphere.plugin.tcp;

import lombok.Data;

import java.util.List;

@Data
public class TCPEnvironment {
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
