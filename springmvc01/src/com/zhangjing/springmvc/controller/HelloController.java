package com.zhangjing.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	/**\
	 * 处理客户端的请求，http://localhost:8888/springmvc01/hello
	 * RequestMapping:完成球球
	 */
	@RequestMapping(value="hello")
	public String hello() {
		System.out.println("HelloController...hello...");
		return "hello";
	}
}
