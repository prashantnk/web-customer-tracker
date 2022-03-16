package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	inject customerService implementation
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

	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam int customerId, Model model) {

		Customer c = customerService.getCustomer(customerId);

		model.addAttribute("customer", c);

		return "customer-form";
	}

	@GetMapping("deleteCustomer")
	public String deleteCustomer(@RequestParam int customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}

	@GetMapping("search")
	public String SearchCustomer(@RequestParam("name") String name, Model model) {
		List<Customer> customers = customerService.searchCustomers(name);

		model.addAttribute("customers", customers);
		model.addAttribute("name", name);

		return "list-customers";
	}

}
