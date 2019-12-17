package cn.roilat.framework.core.netty;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "netty")
public class NettyConfig {
    private int bossThreadCount;

    private int workerThreadCount;

    private int tcpPort;

    private boolean keepAlive;

    private int backlog;

    @Resource
    private NettyHandlersInitalizer nettyHandlersInitalizer;
  
    @SuppressWarnings("unchecked")  
    @Bean(name = "serverBootstrap")  
    public ServerBootstrap bootstrap() {  
        ServerBootstrap b = new ServerBootstrap();  
        b.group(bossGroup(), workerGroup())  
                .channel(NioServerSocketChannel.class)  
                .childHandler(nettyHandlersInitalizer);
        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();  
        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();  
        for (@SuppressWarnings("rawtypes")  
        ChannelOption option : keySet) {  
            b.option(option, tcpChannelOptions.get(option));  
        }  
        return b;  
    }  
  
    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")  
    public NioEventLoopGroup bossGroup() {  
        return new NioEventLoopGroup(bossThreadCount);  
    }  
  
    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")  
    public NioEventLoopGroup workerGroup() {  
        return new NioEventLoopGroup(workerThreadCount);  
    }  
    @Bean(name = "tcpSocketAddress")  
    public InetSocketAddress tcpPort() {  
        return new InetSocketAddress(tcpPort);  
    }  
  
    @Bean(name = "tcpChannelOptions")  
    public Map<ChannelOption<?>, Object> tcpChannelOptions() {  
        Map<ChannelOption<?>, Object> options = new HashMap<ChannelOption<?>, Object>();  
        options.put(ChannelOption.SO_KEEPALIVE, keepAlive);  
        options.put(ChannelOption.SO_BACKLOG, backlog);  
        return options;  
    }  

  
    /** 
     * Necessary to make the Value annotations work. 
     *  
     * @return 
     */  
    @Bean  
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {  
        return new PropertySourcesPlaceholderConfigurer();  
    }

    public void setBossThreadCount(int bossThreadCount) {
        this.bossThreadCount = bossThreadCount;
    }

    public void setWorkerThreadCount(int workerThreadCount) {
        this.workerThreadCount = workerThreadCount;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }
}
