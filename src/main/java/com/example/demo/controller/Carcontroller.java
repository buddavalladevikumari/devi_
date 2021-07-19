package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarData;
import com.example.demo.reposotory.Datarepository;

@RestController
@RequestMapping("/carcontroller")
//@Controller
public class Carcontroller {

	@Autowired
	private CarData cardata;

	@Autowired
	private Datarepository repo;

	@RequestMapping(value = "/cardata", method = RequestMethod.GET)
	public String initForm(Model model) {
		System.out.println("initForm started...");
		
		int rowadded = repo.addcar(cardata);
		System.out.println("rowadded--->"+rowadded);

		System.out.println("pojo object==> "+cardata);
		model.addAttribute("rowAdded", rowadded);

		model.addAttribute("command");
//		model.addAttribute("command", "Hello");
		System.out.println("initForm ending...");

		return "addcar";
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public String submitform(@ModelAttribute("command") CarData cardata, Model model) {

		int rowadded = repo.addcar(cardata);

		System.out.println(cardata);
		model.addAttribute("rowAdded", rowadded);

		return "addcar";
	}
	
	@RequestMapping(value="/cardata/all",method = RequestMethod.GET)
	public String findallcustomer(Model model) {
		
		List<CarData> list = repo.getallcardata();
		model.addAttribute("list",list);
		
		return "showdetails";}
}
