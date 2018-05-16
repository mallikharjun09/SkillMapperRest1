package com.niit.skillmapperrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.model.Skills;
import com.niit.skillmapper.services.EmployeeServices;
import com.niit.skillmapper.services.SkillService;



@RestController
public class SkillMapperRest {
     @Autowired
     EmployeeServices employeeService;
     @Autowired
     SkillService skillService;
     @PostMapping("registerEmployee")
     public ResponseEntity<String> registerEmployee(@RequestBody Employee employee){
    	 employeeService.registerNewEmployee(employee);
    	 return new ResponseEntity<String>("Registered Successfully",HttpStatus.OK);
     }
     
     @PostMapping("getEmployee")
     public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee){
    	 //Employee employee=employeeService.displayEmployeeDetails(""+empObject.getEmployeeId().intValue());
    	 return new ResponseEntity<Employee>(employeeService.displayEmployeeDetails(employee.getEmployeeId()+""),HttpStatus.OK);
     }
     
     @RequestMapping("/")
     public String showHome(){
    	 return "index";
     }
     
     @PostMapping("addSkills")
     public ResponseEntity<String> addSkills(@RequestBody Skills skills){
    	 skillService.addSkills(skills);
    	 return new ResponseEntity<String>("Registered Successfully",HttpStatus.OK);
     }
     
     @PostMapping("getSkills")
     public ResponseEntity<Skills> getSkills(@RequestBody Employee employee){
    	 Skills skill=skillService.displaySkills(employee.getEmployeeId());
    	 return new ResponseEntity<Skills>(skill,HttpStatus.OK);
     }
     
    
     @GetMapping("getAllEmployees")
     public ResponseEntity<List<Employee>> getAllEmployees(){
    	 List<Employee> list=employeeService.displayAllEmployees();
    	 return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
     }
     
}
