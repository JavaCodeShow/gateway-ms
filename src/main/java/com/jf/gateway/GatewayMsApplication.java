package com.jf.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.jf.common.utils.config.JfCommonUtilsConfig;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-05-26 16:07
 * @since: 2.20.1.1
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import({ JfCommonUtilsConfig.class })
public class GatewayMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayMsApplication.class, args);
	}
}