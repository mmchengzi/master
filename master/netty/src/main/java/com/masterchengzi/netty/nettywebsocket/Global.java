package com.masterchengzi.netty.nettywebsocket;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
*User zjc
*Created with IntelliJ IDEA
*Created on 2018-11-09 11:40
*存储类
 以下类是用来存储访问的channle，channelGroup的原型是set集合，保证channle的唯一，如需根据参数标注存储，可以使用currentHashMap来存储。

 */
public class Global {
	public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}

