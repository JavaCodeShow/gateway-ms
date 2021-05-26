package com.jf.gateway.filter;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-05-26 17:05
 * @since: 2.20.1.1
 */

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 可进行日志打印，鉴权等
 */
@Slf4j
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange,
			GatewayFilterChain chain) {
		log.info("custom global filter");
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}