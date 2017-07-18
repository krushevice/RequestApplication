package by.iba.requestApp.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import by.iba.requestApp.delegate.LoginDelegate;
import by.iba.requestApp.delegate.OrderDelegate;
import by.iba.requestApp.viewBean.OrderBean;
import by.iba.requestApp.viewBean.RequestBean;

@Controller
public class RequestController {
	
	@Autowired  
	private OrderDelegate orderDelegate;
	@Autowired  
	private LoginDelegate loginDelegate;

	@RequestMapping(value = { "/viewReq" }, method = RequestMethod.GET)    
	public String ordersOneUser(@RequestParam int id, ModelMap model) throws SQLException { 
        List<OrderBean> orders = orderDelegate.selectOrdersByUserId(id);
        model.addAttribute("orders", orders);
        model.addAttribute("id", id);
        model.addAttribute("all", "no");       
        return "viewReq";
    }
	
	@RequestMapping(value = { "/viewAllReq" }, method = RequestMethod.GET)    
	public String ordersAll(@RequestParam int id, ModelMap model) throws SQLException {
        List<OrderBean> orders = orderDelegate.selectAllOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("id", id);
        model.addAttribute("all", "yes");
        return "viewReq";
    }
	
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel(@RequestParam int id, ModelMap model) {
        List<OrderBean> orders = orderDelegate.selectOrdersByUserId(id);
        model.addAttribute("orders", orders);
        model.addAttribute("id", id);
		return new ModelAndView("excelView", model);
	}
	
	@RequestMapping(value = "/downloadAllExcel", method = RequestMethod.GET)
	public ModelAndView downloadAllExcel(@RequestParam int id, ModelMap model) throws SQLException {
        List<OrderBean> orders = orderDelegate.selectAllOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("id", id);
		return new ModelAndView("excelView", model);
	}
	 
	 @RequestMapping(value = "/createReq", method=RequestMethod.POST)
	 public ModelAndView insertOrder(@ModelAttribute("reqBean")RequestBean reqBean, BindingResult result, RedirectAttributes redirectAttributes){
		 ModelAndView model = new ModelAndView();	
		 if (!result.hasErrors()) {
			 RedirectView view = new RedirectView("createReqTest");
			 model.setView(view);
			 model.addObject("id", reqBean.getUserId());	
			 redirectAttributes.addAttribute("message","Request completes successfully!");
		 }
		 else {				 
			 model.setViewName("createReqTest");
			 redirectAttributes.addAttribute("message", "Sorry, something went wrong!");
		 }
		 try {
			 boolean reg = orderDelegate.insertOrder(reqBean);
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return model;
	 }
	 
	 @RequestMapping(value = "/createReqTest", method=RequestMethod.GET)
	 public ModelAndView createReqTest(@RequestParam int id, @ModelAttribute("reqBean")RequestBean reqBean, @ModelAttribute("message")String message,HttpServletRequest request, RedirectAttributes redirectAttributes){
		 ModelAndView model = new ModelAndView();
		 model.setView(new RedirectView("createReq"));
		 model.addObject("id", id);
		 redirectAttributes.addAttribute("message", message);
		 Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		 if (map != null) {
			 	//System.out.println("It is redirect!");
			} else {
				//System.out.println("It is update!");
			}
		 return model;
	 }		
		
	 @RequestMapping(value = "/createReq", method=RequestMethod.GET)
	 public ModelAndView createRequest(@RequestParam int id, @ModelAttribute("message")String message){
		 ModelAndView model = new ModelAndView("createReq");
		 RequestBean requestBean = new RequestBean();
		 model.addObject("requestBean", requestBean);
		 model.addObject("message", message);
		 model.addObject("id", id);
		 return model;
	 }
	 
	 @RequestMapping(value = "/deleteOrder", method=RequestMethod.POST)
	 public String deleteOrder(int userId, int orderId){
		 orderDelegate.deleteOrder(orderId);
		 if(userId==1){
			 return "redirect:viewAllReq?id="+userId;
		 }else{
			 return "redirect:viewReq?id="+userId;
		 }
	 }
}

