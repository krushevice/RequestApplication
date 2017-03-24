package by.iba.requestApp.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.iba.requestApp.delegate.LoginDelegate;
import by.iba.requestApp.viewBean.LoginBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController{
	@Autowired  
	private LoginDelegate loginDelegate;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(){
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}
	@RequestMapping(value="/login**",method=RequestMethod.POST)
	public ModelAndView executeLogin(@ModelAttribute("loginBean")LoginBean loginBean){

		ModelAndView model= null;
		try{
			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
			if(isValidUser){
				System.out.println("User Login Successful");
				model = new ModelAndView("home");
				model.addObject("username", loginBean.getUsername());
			}else{
				model = new ModelAndView("login");
				model.addObject("message", "Name or password is incorrect!");
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return model;
	}
}

