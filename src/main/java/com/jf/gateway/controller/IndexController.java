package com.jf.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "gateway-ms is running.";
	}

}