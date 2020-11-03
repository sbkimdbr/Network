package com.tcpip;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chat.Client;

@Controller
public class MainController {

	Client client;
	
    public MainController() {
	  client = new Client("192.168.123.107",5555,"[WEB]");
	  try {
		client.Connect();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/iot.mc")
	public void iot() {
		System.out.println("Iot send start...");
		client.sendTarget("192.168.123.107", "100");
		//PrinteWritter out = res.getWriter();
		//out.print("ok");
		//out.close();
	}
	@RequestMapping("/ftest.do")
	public void phone() {
		System.out.println("Phone send start...");
	}
	
}
