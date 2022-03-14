package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	inject CustomerDAO implementation
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

//		get the customers and add it to the model

		List<Customer> customers = customerService.getCustomers();

		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {

//		all entry in the form will go into this attribute

		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer c) {

		customerService.saveCustomer(c);

		return "redirect:list";
	}

}
