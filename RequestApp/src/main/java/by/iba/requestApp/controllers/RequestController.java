package by.iba.requestApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestController {
	@RequestMapping(value = "/createRequest", method = RequestMethod.GET)
		public String createRequest() {
		return "createRequest";
	}

	@RequestMapping(value = "/viewRequests", method = RequestMethod.GET)
		public String viewRequests() {
		return "viewRequests";
	}
}
