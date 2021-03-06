package com.jf.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 描述: 权限校验过滤器
 *
 * @author: 江峰
 * @create: 2021-05-26 17:43
 * @since: 2.20.1.1
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange,
			GatewayFilterChain chain) {
		String token = exchange.getRequest().getHeaders().getFirst("token");

		log.info("token = [{}]", token);

		// if ("token".equals(token)) {
		return chain.filter(exchange);
		// }
	}

	@Override
	public int getOrder() {
		return -1;
	}
}