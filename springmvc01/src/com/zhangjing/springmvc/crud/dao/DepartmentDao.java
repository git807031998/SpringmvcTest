package com.zhangjing.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zhangjing.springmvc.crud.model.Department;

@Repository
public class DepartmentDao {

	/**
	 * 这个使用map构造数据
	 */
	private static Map<Integer,Department> departments = null;
	
	static {
		departments = new HashMap<Integer,Department>();
		departments.put(101, new Department(101,"DEP101"));
		departments.put(102, new Department(102,"DEP102"));
		departments.put(103, new Department(103,"DEP103"));
		departments.put(104, new Department(104,"DEP104"));
	}
	
	/**
	 * 获取所有部门的数据
	 */
	
	public Collection<Department> getAllDepartments() {
		return departments.values();
	}
	
	/**
	 * 根据单条部门数据
	 */
	public Department getDepartment(Integer id) {
		return departments.get(id);
	}
}
