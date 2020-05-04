package com.zhangjing.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestModelViewController {

	@RequestMapping("testmodelandview")
	public ModelAndView test1() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "admin");
		mav.setViewName("mav");
		return mav;
				
	}
	
	@RequestMapping("testmap")
	public String test2(Map<String,Object> map) {
		
		System.out.println(map.getClass().getName());
		map.put("username", "admin123");
		return "mav";
				
	}
	
	@RequestMapping("testmodel")
	public String test3(Model model) {
		
		model.addAttribute("username", "testmodel");
		return "mav";
				
	}
	
	@RequestMapping("testredirect")
	public String test4(){
		return "redirect:/ok.jsp";
	}
	
}
