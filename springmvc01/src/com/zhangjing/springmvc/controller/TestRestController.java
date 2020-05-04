package com.zhangjing.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class TestRestController {

	@RequestMapping(value="order/{id}",method=RequestMethod.GET)
	public String testget(@PathVariable("id") Integer orderid) {
		System.out.println("rest get test===="+orderid);
		return "test";
	}
	
	@RequestMapping(value="order/{id}",method=RequestMethod.DELETE)
	public String testdelete(Integer orderid) {
		System.out.println("rest delelte test===="+orderid);
		return "test";
	
	}
	
	@RequestMapping(value="order",method=RequestMethod.POST)
	public String testpost() {
		System.out.println("rest post test ====");
		return "test";
	}
	 @RequestMapping(value="order",method=RequestMethod.PUT)
	public String testput() {
		System.out.println("rest put test===");
		return "test";
	}
}
