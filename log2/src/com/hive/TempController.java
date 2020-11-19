package com.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.Temp;
import com.frame.Temperature;

@Controller
public class TempController {

	
	@Autowired
	Temperature<Temp> temperature;
	
	@RequestMapping("/tempstatus.mc")
	public void tempstatus(Temp ttemp) {
		System.out.println(ttemp);
		temperature.status(ttemp);
		//ttemp가 실제 온도 값을 가지고 있는 최종의 집합 
	}
	
}
