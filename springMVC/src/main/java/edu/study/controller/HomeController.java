package edu.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/test.do",method= RequestMethod.GET)
	public String test() {
		return "sample/sample";
		// sample/sample
	}
	
	@RequestMapping(value="/oper/calc.do", method=RequestMethod.GET)
	public String calc() {
		return "oper/calculator";
	}
	
	@RequestMapping(value="/oper/calc.do", method=RequestMethod.POST)
	public String calc(int num1, int num2, String oper,Model model) {
		
		int result = 0;
		
		if(oper != null && !oper.equals("")) {
			if(oper.equals("plus")) {
				result = num1+num2;
			}else if(oper.equals("minus")) {
				result = num1-num2;
			}else if(oper.equals("multi")) {
				result = num1*num2;
			}else if(oper.equals("div")) {
				result = num1/num2;
			}
			
			model.addAttribute("result", result);
		}else {
			model.addAttribute("result", "유효하지 않은 연산자입니다.");
		}
		
		return "oper/result";
	}
	
	
}





