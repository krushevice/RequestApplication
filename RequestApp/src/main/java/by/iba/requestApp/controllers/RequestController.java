package by.iba.requestApp.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.iba.requestApp.delegate.OrderDelegate;
import by.iba.requestApp.service.OrderService;
import by.iba.requestApp.viewBean.RequestBean;

@Controller
public class RequestController {
	
	@Autowired  
	private OrderDelegate orderDelegate;
	
	@RequestMapping(value = "/createReq", method=RequestMethod.GET)
	public ModelAndView createRequest(){
		System.out.println("createRequest");
		ModelAndView model = new ModelAndView("createReq");
		RequestBean requestBean = new RequestBean();
		model.addObject("requestBean", requestBean);
		return model;
	}	

	/*@RequestMapping(value = "/viewReq", method = RequestMethod.GET)
		public String viewRequests() {
		return "viewReq";
	}*/
	
	@RequestMapping(value = { "/viewReq" }, method = RequestMethod.GET)    
	public String listUsers(ModelMap model) throws SQLException {
 
        List<RequestBean> orders = orderDelegate.selectAllOrders();
        System.out.println("orders = " + orders);
        model.addAttribute("orders", orders);
        return "viewReq";
    }
	
	
	@RequestMapping(value = "/createReq", method=RequestMethod.POST)
	public ModelAndView insertOrder(@ModelAttribute("reqBean")RequestBean reqBean){
		System.out.println("insertRequest");
		ModelAndView model= null;
		try{
			boolean reg = orderDelegate.insertOrder(reqBean);
			if(reg){
				model = new ModelAndView("createReq");
				model.addObject("message", "Creation complites successfully!");
			}else{
				model = new ModelAndView("createReq");
				model.addObject("message", "Creation error!");
			}				
		}catch(Exception e){
			e.printStackTrace();
		}

		return model;
	}
}

