package by.iba.requestApp.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.iba.requestApp.delegate.LoginDelegate;
import by.iba.requestApp.delegate.OrderDelegate;
import by.iba.requestApp.viewBean.RequestBean;

@Controller
public class HomeController {
	
	@Autowired  
	private LoginDelegate loginDelegate;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayHome() {
		return "loginB";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String gohome(@RequestParam int id, ModelMap model) {
		String role = "";
		try {
			role = loginDelegate.getUserRoleById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        model.addAttribute("role", role);
        model.addAttribute("id", id);
		return "home";
	}  

}
