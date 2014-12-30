package com.mediaocean.marketknowledge.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mediaocean.marketknowledge.applicationexception.ApplicationException;
import com.mediaocean.marketknowledge.entity.Product;
import com.mediaocean.marketknowledge.service.ReportingService;


@Controller
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private ReportingService reportingService;
	
	@ModelAttribute("product")
	public Product getProduct(){
		return new Product();
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String retriveProducts(Locale locale, Map<String, Object> model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		try{
			List<Product> productList = reportingService.retriveAllProductSalesEntries();
			model.put("product", productList);
		}catch(ApplicationException apex){
			apex.getMessage();
		}
		return "product";
	}
}
