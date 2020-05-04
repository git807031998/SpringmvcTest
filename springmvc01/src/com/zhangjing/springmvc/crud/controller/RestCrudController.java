package com.zhangjing.springmvc.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangjing.springmvc.crud.dao.DepartmentDao;
import com.zhangjing.springmvc.crud.dao.EmployeeDao;
import com.zhangjing.springmvc.crud.model.Department;
import com.zhangjing.springmvc.crud.model.Employee;

@Controller
@RequestMapping("restcrud")
public class RestCrudController {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value="emp",method=RequestMethod.GET)
	public String toAddPage(Map<String,Object> map) {
		Collection<Department>  depts = departmentDao.getAllDepartments();
		map.put("depts", depts);
		Map<String,String> genders = new HashMap<String,String>();
		genders.put("0", "female");
		genders.put("1", "male");
		map.put("genders", genders);
		
		//map.put("command",new Employee());
		map.put("employee",new Employee());
		return "input";
	}
	
	@RequestMapping(value="emps",method=RequestMethod.GET)
	public String listAllEmps(Map<String,Object> map) {
		Collection<Employee> emps = employeeDao.getAll();
		map.put("emps", emps);
		return "list";
	}
	
	@RequestMapping(value="emp",method=RequestMethod.POST)
	public String addEmp(Employee emp) {
		employeeDao.save(emp);
		return "redirect:emps";
	}
	
	@RequestMapping(value="emp/{id}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id")Integer id) {
		employeeDao.delete(id);
		System.out.println("del .."+id);
		return "redirect:../emps";
	}
	
	@RequestMapping(value="emp/{id}",method=RequestMethod.GET)
	public String toUpdatePage(@PathVariable("id")Integer id,Map<String,Object> map) {
		Employee employee = employeeDao.get(id);
		System.out.println("get .."+id);
		
		map.put("employee",employee);
		
		Collection<Department>  depts = departmentDao.getAllDepartments();
		map.put("depts", depts);
		Map<String,String> genders = new HashMap<String,String>();
		genders.put("0", "female");
		genders.put("1", "male");
		map.put("genders", genders);
		return "input";
	}
	
	/**
	 * 修改功能: 具体的修改操作
	 */
	@RequestMapping(value = "/emp",method= RequestMethod.PUT)
	public String updateEmp(Employee employee) {
		employeeDao.save(employee);
		
		return "redirect:emps";
	}
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson() {
		Collection<Employee> emps = employeeDao.getAll();
		return emps;
	}
	
	
}
