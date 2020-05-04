package com.zhangjing.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zhangjing.springmvc.crud.model.Department;

@Repository
public class DepartmentDao {

	/**
	 * ���ʹ��map��������
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
	 * ��ȡ���в��ŵ�����
	 */
	
	public Collection<Department> getAllDepartments() {
		return departments.values();
	}
	
	/**
	 * ���ݵ�����������
	 */
	public Department getDepartment(Integer id) {
		return departments.get(id);
	}
}
