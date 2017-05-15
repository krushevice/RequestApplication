package by.iba.requestApp.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.iba.requestApp.service.StageService;
import by.iba.requestApp.viewBean.LoginBean;
import by.iba.requestApp.viewBean.OrderBean;
import by.iba.requestApp.viewBean.StageBean;

@Controller
public class StageController {
	@Autowired  
	private StageService stageService;
	
	@RequestMapping(value = "/orderStage", method = RequestMethod.GET)
	public ModelAndView orderStage(@RequestParam int id, @RequestParam int orderId) {
        
        List<StageBean> stages = null;
		try {
			stages = stageService.selectOrderStages(orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("stages = " + stages);
		
		ModelAndView model = new ModelAndView("orderStage", "stages", stages);
		
		//model.addObject("stageBean", new StageBean());
		model.addObject("id", id);
		model.addObject("orderId", orderId);
		
        return model;
	}
	
	@RequestMapping(value="/updateStage", method=RequestMethod.POST)
	public String executeStage(@ModelAttribute("stageBean")StageBean stageBean, int userId){
		System.out.println("123 stageBean="+ stageBean);
		//ModelAndView model= null;
		try{
			//stageBean.setStageOne(2);
			//stageService.updateOrderStage(stageBean.getOrderId(), stage);
			stageService.updateOrderStage(stageBean);
			boolean isComplete = stageService.isComplete(stageBean.getOrderId());
			if(isComplete){
				System.out.println("isComplete1="+isComplete);
				stageService.finishOrder(stageBean.getOrderId());
				return "redirect:viewAllReq?id="+userId;
			}
			//model = new ModelAndView("orderStage");
			//model.addObject("orderId", stageBean.getOrderId());
			//model.addObject("id", id);
			System.out.println("isComplete2="+isComplete);

		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
		}

		return "redirect:orderStage?id="+userId+"&orderId="+stageBean.getOrderId();
	}
}
