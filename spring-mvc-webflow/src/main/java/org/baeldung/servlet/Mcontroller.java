package org.baeldung.servlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class Mcontroller {

	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title","Home");
		return mv;
	}
	
}
