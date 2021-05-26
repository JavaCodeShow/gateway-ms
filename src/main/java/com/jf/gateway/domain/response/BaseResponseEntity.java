package com.jf.gateway.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-05-26 17:54
 * @since: 2.20.1.1
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseEntity {

	/**
	 * 返回code
	 */
	private Integer code;

	/**
	 * 描述
	 */
	private String message;
}
