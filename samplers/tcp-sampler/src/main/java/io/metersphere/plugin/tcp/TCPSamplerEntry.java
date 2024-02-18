package io.metersphere.plugin.tcp;

import io.metersphere.plugin.api.annotation.PluginSubType;
import io.metersphere.plugin.api.spi.AbstractMsTestElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.pf4j.Extension;

@Data
@EqualsAndHashCode(callSuper = true)
@PluginSubType("TCPSamplerEntry")
@Extension
public class TCPSamplerEntry extends AbstractMsTestElement {
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
        return "MsTCPSampler(comments=" + this.getComments() + ", classname=" + this.getClassname() + ", serverIp=" + this.getServerIp() + ", port=" + this.getPort() + ", connTimeout=" + this.getConnTimeout() + ", resTimeout=" + this.getResTimeout() + ", reUseConnection=" + this.isReUseConnection() + ", noDelay=" + this.isNoDelay() + ", closeConnection=" + this.isCloseConnection() + ", soLinger=" + this.getSoLinger() + ", eolByte=" + this.getEolByte() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", request=" + this.getRequest() + ")";
    }
}
