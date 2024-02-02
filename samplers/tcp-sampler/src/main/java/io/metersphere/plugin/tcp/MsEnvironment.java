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

    public String toString() {
        return "MsEnvironment(comments=" + this.getComments() + ", classname=" + this.getClassname() + ", serverIp=" + this.getServerIp() + ", port=" + this.getPort() + ", connTimeout=" + this.getConnTimeout() + ", resTimeout=" + this.getResTimeout() + ", reUseConnection=" + this.isReUseConnection() + ", noDelay=" + this.isNoDelay() + ", closeConnection=" + this.isCloseConnection() + ", soLinger=" + this.getSoLinger() + ", eolByte=" + this.getEolByte() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", request=" + this.getRequest() + ")";
    }

}
