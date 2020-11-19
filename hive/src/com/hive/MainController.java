package com.hive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		System.out.println("dddd");
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/chart1.mc")
	public ModelAndView chart1() {
		System.out.println("123456");
		ModelAndView mv = new ModelAndView();
		//GET HIVE DATA
		
		//CONVERT JSON
		mv.addObject("centerpage","chart1");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/chart2.mc")
	public ModelAndView chart2() {
		System.out.println("dddd");
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage","chart2");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/chart3.mc")
	public ModelAndView chart3() {
		System.out.println("dddd");
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage","chart3");
		mv.setViewName("main");
		return mv;
	}
	
}
