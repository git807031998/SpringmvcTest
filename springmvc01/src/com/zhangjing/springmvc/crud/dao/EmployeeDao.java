package com.zhangjing.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhangjing.springmvc.crud.model.Department;
import com.zhangjing.springmvc.crud.model.Employee;

@Repository
public class EmployeeDao {
	private static  Map<Integer,Employee> employees =null;
	static {
		employees = new HashMap<Integer,Employee> ();
		employees.put(1001, new Employee(1001,"emp101001","emp101001@zhangjing.com",1,new Department(101,"DEP101")));
		employees.put(1002, new Employee(1002,"emp101002","emp101002@zhangjing.com",1,new Department(101,"DEP101")));
		employees.put(1003, new Employee(1003,"emp101003","emp101003@zhangjing.com",1,new Department(101,"DEP101")));
		employees.put(1004, new Employee(1004,"emp102001","emp102001@zhangjing.com",1,new Department(102,"DEP102")));
		employees.put(1005, new Employee(1005,"emp102002","emp102002@zhangjing.com",1,new Department(102,"DEP102")));
		employees.put(1006, new Employee(1006,"emp103001","emp103001@zhangjing.com",1,new Department(103,"DEP103")));
		employees.put(1007, new Employee(1007,"emp103002","emp103002@zhangjing.com",1,new Department(103,"DEP103")));
		employees.put(1008, new Employee(1008,"emp103003","emp103003@zhangjing.com",1,new Department(103,"DEP103")));
		employees.put(1009, new Employee(1009,"emp103004","emp103004@zhangjing.com",1,new Department(103,"DEP103")));
		
	}
	
	//初始化id
	private static Integer initId = 1010;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	
	
	
	
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		//注意
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	/**
	 * 获取所有
	 * @return
	 */
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	/**
	 * 获取单个
	 * @param id
	 * @return
	 */
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id){
		employees.remove(id);
	}
}
