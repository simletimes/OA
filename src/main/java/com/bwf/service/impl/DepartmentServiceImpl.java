package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.DepartmentMapper;
import com.bwf.entity.Department;
import com.bwf.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
	@Autowired
	com.bwf.dao.DepartmentMapper departmentMapper;

	@Override
	public List<Department> getAll() {
		
		return departmentMapper.getAll();
	}

}
