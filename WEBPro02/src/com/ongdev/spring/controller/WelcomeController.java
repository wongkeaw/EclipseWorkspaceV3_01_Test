package com.ongdev.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ongdev.spring.domain.Message;

@Controller
@Scope("session")
public class WelcomeController {
	private String view = "welcome" ;
	public Map<String, Object> modelMap = new HashMap<String, Object>() ;
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		System.out.println("HelloWorld");
		String message = " ongart test";
		modelMap.put("message", message) ;
		modelMap.put("model", new Message("Name", "Text") ) ;
		ModelAndView model = new ModelAndView(view) ;
		model.addAllObjects(modelMap) ;
		return model ;
	}
	@RequestMapping("/welcome2")
	public ModelAndView helloWorld2() {
		System.out.println("HelloWorld");
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome2", "message", message);
	}
	public Map<String, Object> getModelMap() {
		return modelMap ;
	}
}