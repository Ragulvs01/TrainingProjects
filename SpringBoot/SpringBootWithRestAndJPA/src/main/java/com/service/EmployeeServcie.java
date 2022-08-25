package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeServcie {
 @Autowired
 EmployeeDao employeeDao;
 public Employee findEmployeeByID(int id) {
	 return employeeDao.getEmployeeDetails(id);
 }
 public List<Employee> getAllEmployee(){
	 return employeeDao.getAllEmployeeDetails();
 }
 public String storeEmployee(Employee emp) {
	 if(employeeDao.storeEmployee(emp)>0) {
		 return"stored";
	 }else {
		 return"Not Stored";
	 }
 }
}
