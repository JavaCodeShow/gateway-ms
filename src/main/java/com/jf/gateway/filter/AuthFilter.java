package com.jf.gateway.filter;

import java.nio.charset.StandardCharsets;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;
import com.jf.gateway.domain.response.BaseResponseEntity;

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

		if ("token".equals(token)) {
			return chain.filter(exchange);
		}

		ServerHttpResponse response = exchange.getResponse();

		BaseResponseEntity data = BaseResponseEntity.builder().code(401)
				.message("非法请求").build();
		byte[] datas = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
		DataBuffer buffer = response.bufferFactory().wrap(datas);
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		response.getHeaders().add("Content-Type",
				"application/json;charset=UTF-8");
		return response.writeWith(Mono.just(buffer));
	}

	@Override
	public int getOrder() {
		return -1;
	}
}