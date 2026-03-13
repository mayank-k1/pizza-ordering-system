package com.accenture.lkm.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.bean.PizzaBean;
import com.accenture.lkm.bean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;

@Controller
public class PizzaOrderController {

	@Autowired
	private PizzaService pizzaService;

	@RequestMapping(value = "/LoadPizzaOrder", method = RequestMethod.GET)
	public ModelAndView loadSavePizza() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PizzaOrder");
		modelAndView.addObject("pizzaOrderObj", new PizzaOrderBean());
		return modelAndView;

	}

	/**
	 * To-Do Item 1.11: This method should save the details of PizzaOrderBean. TODO:
	 * --Map the URL to /SavePizzaOrder --Retrieve the PizzaOrderBean submitted by
	 * the view. --Perform validation checks. --If validation fails, populate a
	 * ModelAndView object with "PizzaOrder" as the logical view to display error
	 * message. --On successful form validation, it should invoke the
	 * addPizzaOrderDetails method of PizzaService. --Create and populate a
	 * ModelAndView object with "PizzaOrderSuccess" as the logical view name and add
	 * an appropriate message along with order id and bill.
	 * 
	 */

	@RequestMapping(value = "/SavePizzaOrder", method = RequestMethod.POST)
	public ModelAndView addPizzaOrderDetails(@Valid @ModelAttribute("pizzaOrderObj") PizzaOrderBean pizzaOrderBean,
			BindingResult bindingResult) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		// Validation check
		if (bindingResult.hasErrors()) {
			// If validation fails, return to PizzaOrder form with errors
			modelAndView.setViewName("PizzaOrder");
			return modelAndView;
		}

		PizzaOrderBean savedOrder = pizzaService.addPizzaOrderDetails(pizzaOrderBean);

		modelAndView.setViewName("PizzaOrderSuccess");
		modelAndView.addObject("message", "Order placed successfully!");
		modelAndView.addObject("orderId", savedOrder.getOrderId()); 
		modelAndView.addObject("bill", savedOrder.getBill()); 

		return modelAndView;

	}

	/**
	 * To-Do Item 1.12: This method should be executed before any handler method of
	 * this controller and should populate pizza names dynamically in the form.
	 * TODO: --It should invoke the findAllPizzaDetails of PizzaService. 
	 * --Return a Map containing Pizza id and Pizza names.
	 */

	@ModelAttribute("pizzaList")
	public Map<Integer, String> populatePizzaNames() throws Exception {
		/*List<PizzaBean> pizzaList = (List<PizzaBean>) pizzaService.findAllPizzaDetails(); 
																							
		Map<Integer, String> pizzaMap = new HashMap<>();

		for (PizzaBean pizza : pizzaList) {
			pizzaMap.put(pizza.getPizzaId(), pizza.getPizzaName());
		}

		return pizzaMap;*/
		return pizzaService.findAllPizzaDetails();
	}

	/**
	 * To-Do Item 1.13: This method should handle common exceptions. TODO:
	 * --Annotate the method with appropriate annotation to indicate it handles
	 * Exception. --It should create a 'ModelAndView' object to render the view and
	 * populate data. --It should set the view name to
	 * "GeneralizedExceptionHandlerPage".This view will be responsible for
	 * displaying the error message to the user. --It should add the exception
	 * message to the ModelAndView object with a key "message". This message will be
	 * accessible in the view(GeneralizedExceptionHandlerPage.jsp) for display.
	 * --Finally,it should return the populated ModelAndView object.
	 */

	 @ExceptionHandler(Exception.class)
	    public ModelAndView handleAllExceptions(Exception exception) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("GeneralizedExceptionHandlerPage");
	        modelAndView.addObject("message", exception.getMessage());
	        return modelAndView;
	    }
}
