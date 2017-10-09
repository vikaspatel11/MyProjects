package com.inteliment.counterapi.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inteliment.counterapi.services.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getall", method = RequestMethod.GET) 
	public String getAllEmployee() {
		return service.getAll();
		
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST) 
	public String addEmployee(@RequestBody String input) {
		JSONObject obj = new JSONObject(input);
		System.out.println("Add:"+input);
		return service.add(obj);
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST) 
	public String removeEmployee(@RequestBody String id) {
		JSONObject obj = new JSONObject(id);
		System.out.println("Remove:"+id);
		return service.remove(obj.getInt("id"));
	}
	
	
}
