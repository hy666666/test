package com.myspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class SpringDemoController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}

