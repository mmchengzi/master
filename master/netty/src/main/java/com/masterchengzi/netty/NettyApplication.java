package com.masterchengzi.netty;

import com.masterchengzi.netty.nettywebsocket.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NettyApplication extends SpringBootServletInitializer {

		@Override
		protected SpringApplicationBuilder configure(
				SpringApplicationBuilder application) {
			return application.sources(NettyApplication.class);
		}


		public static void main(String[] args) {
		SpringApplication.run(NettyApplication.class, args);
	}
}
