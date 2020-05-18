package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Employee;
import in.nit.service.IEmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;


	//1. Show Employee Register page
	@RequestMapping("/register") //default GET
	public String showReg(Model model) {
		//FORM-BACKING OBJECT
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}

	//2. on click submit read data
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(
			@ModelAttribute Employee employee,
			Model model) 
	{
		//save data in DB
		Integer id=service.saveEmployee(employee);
		//send message to UI
		model.addAttribute("message", "Employee '"+id+"' saved.");

		//FORM-BACKING OBJECT
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}

	//3. Fetch all rows and show at UI
	@RequestMapping("/all")
	public String showAll(Model model) {
		List<Employee> list=service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	//4. on click delete remove data
	@RequestMapping("/remove")
	public String delete(@RequestParam Integer id) {
		//delete based on Id
		service.deleteEmployee(id);
		//redirect to Data page
		return "redirect:all";
	}

	//5. show edit page
	@RequestMapping("/edit")
	public String showEdit(
			@RequestParam Integer id,
			Model model)
	{
		Employee emp=service.getOneEmployee(id);
		model.addAttribute("employee", emp);
		return "EmployeeEdit";
	}

	//6. on click update
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute Employee employee) {
		service.updateEmployee(employee);
		//redirect to Data page
		return "redirect:all";
	}
}






