package by.iba.requestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayHome() {
		return "loginB";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String gohome() {
		return "home";
	}

}
