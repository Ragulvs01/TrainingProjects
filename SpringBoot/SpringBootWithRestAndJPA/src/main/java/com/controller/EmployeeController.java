package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.service.EmployeeServcie;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServcie employeeService;
    @RequestMapping(value="employee",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeInfo() {
    	Employee emp1= new Employee(100,"Ajay",4000);
    	return emp1;
    }
    @RequestMapping(value="employees",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployeeDetails(){
    	List<Employee> listOfEmp= new ArrayList<Employee>();
    	listOfEmp.add(new Employee(1,"ram",2000));
    	listOfEmp.add(new Employee(2,"somu",4000));
    	listOfEmp.add(new Employee(3,"venu",8000));
    	return listOfEmp;
    }
    @RequestMapping(value="employeeFromDb",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployeeDetailsFromDb(){
    	return employeeService.getAllEmployee();
    }
    @RequestMapping(value="findEmployeeByID/(id)",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee findEmployeeByID(@PathVariable("id") int eid) {
    
    	return employeeService.findEmployeeByID(eid);
    }
    @RequestMapping(value="storeEmployee",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String storeEmployee(@RequestBody Employee emp) {
    	return employeeService.storeEmployee(emp);
    }
}
