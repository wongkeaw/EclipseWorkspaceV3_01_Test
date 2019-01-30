package com.ongdev.spring.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ongdev.spring.domain.Message;

@RestController
@RequestMapping("/RS")
public class WelcomeRestController {
	
	private String mainController = "welcomeController" ;

    @RequestMapping("/rest")
    public String welcome() {//Welcome page, non-rest
    	System.out.println("welcome");
        return "Welcome to RestTemplate Example.";
    }
 
    @RequestMapping("/rest/hello/{player}")
    public Message message(@PathVariable String player) {//REST Endpoint.
    	System.out.println("message");
        Message msg = new Message(player, "Hello " + player);
        
        return msg;
    }
    @RequestMapping("/rest/map")
    public Map<String, Object> map(HttpServletRequest rq , HttpServletResponse rs ) {
    	System.out.println("map");
    	Enumeration<String> list =  rq.getSession().getAttributeNames() ;

    	while (list.hasMoreElements()) {
			String string = (String) list.nextElement();
			System.out.println(string);
		}
    	try {
			WelcomeController wcc = (WelcomeController) rq.getSession().getAttribute(mainController) ;
			Map<String, Object> modelMap = wcc.getModelMap() ;
			return modelMap ;
		} catch (Exception e) {
			return null ;
		}
    	
    }
}
