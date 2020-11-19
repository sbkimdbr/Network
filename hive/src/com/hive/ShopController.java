package com.hive;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz.Click;
import com.frame.Shop;

@Controller
public class ShopController {

    @Autowired
	Shop<Click> shop;
	@RequestMapping("/shop.mc")
	public ModelAndView shop(HttpServletRequest req) {

		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		String item = req.getParameter("item");
		String price = req.getParameter("price");
		String age = "29";
		String gender = "F";
		//click 
		Click click = new Click(id,item,price,age,gender);
		
		//argument�� ������ ���� ��´�.
		shop.itemClick(click);
		
		//System.out.println(id + "" + item + "" + price);
		//������� ID�� ���ؼ� ������� �����̳� ������ �����´�.

		
        mv.setViewName("main");
		return mv;
	}
}
