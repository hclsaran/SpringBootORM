package com.saran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.saran.model.Employee;
import com.saran.service.EmpServiceImpl;

@Controller
public class EmpController {
	
	@Autowired
	private EmpServiceImpl empService;
	
	@GetMapping("/")
	public String viewEmppage(Model model) {
		model.addAttribute("AllEmp", empService.getAllEmps());
		return "listemp";
	}
	
	@GetMapping("/addnew")
	public String addNewEmpp(Model model) {
		Employee e=new Employee();
		model.addAttribute("employee", e);
		return "newemp";
	}
	
	@PostMapping("/save")  //for inserting purpose
	public String saveEmp(@ModelAttribute("employee") Employee emp) {
		 empService.save(emp);
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmpById/{id}") //removing the resource from table
	public String deleteEmpById(@PathVariable("id") Integer id) {
		empService.deleteEmpById(id);
		return "redirect:/";
	}

}
