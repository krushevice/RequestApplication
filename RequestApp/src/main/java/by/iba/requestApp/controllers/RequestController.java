package by.iba.requestApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.iba.requestApp.viewBean.LoginBean;
import by.iba.requestApp.viewBean.RequestBean;

@Controller
public class RequestController {
	@RequestMapping(value = "/createReq", method=RequestMethod.GET)
	public ModelAndView createRequest(){
		System.out.println("12345");
		ModelAndView model = new ModelAndView("createReq");
		RequestBean requestBean = new RequestBean();
		model.addObject("requestBean", requestBean);
		return model;
	}

	@RequestMapping(value = "/viewReq", method = RequestMethod.GET)
		public String viewRequests() {
		return "viewReq";
	}
}
