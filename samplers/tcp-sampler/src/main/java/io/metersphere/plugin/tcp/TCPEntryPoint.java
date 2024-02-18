package io.metersphere.plugin.tcp;


import io.metersphere.plugin.api.spi.AbstractProtocolPlugin;

public class TCPEntryPoint extends AbstractProtocolPlugin {

    public static final String TCP = "TCP";

    @Override
    public String getName() {
        // 自定义插件名称

        return TCP;
    }

    @Override
    public String getScriptDir() {
        // ui 脚本路径，相对于 resources/script 目录
        // API目前支持两类脚本，一类是环境脚本（id: environment），一类是各种协议脚本(id:api)
        // 脚本渲染方式支持两种，一种是系统内嵌渲染，一种是三方插件FromCreate渲染 (scriptType = "Embedded" | "FormCreate")

        return "script";
    }

    @Override
    public String getProtocol() {
        return TCP;
    }
}
