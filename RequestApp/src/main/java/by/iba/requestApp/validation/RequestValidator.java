package by.iba.requestApp.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.iba.requestApp.viewBean.RequestBean;

@Component
public class RequestValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> myClass) {
		return RequestBean.class.isAssignableFrom(myClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RequestBean requestBean = (RequestBean) target;
		int product = requestBean.getProduct();		
		if (product == 0) {
			errors.rejectValue("product", "product can't be empty!");
		}
		
		int count = requestBean.getCount();		
		if (count == -1) {
			errors.rejectValue("count", "count must be positive!");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "count", "count.empty","count can't be empty!");

		
		
		
	}
	

}
