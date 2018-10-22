package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Department;
import com.bwf.entity.Role;
import com.bwf.service.IDepartmentService;
import com.bwf.service.IRoleService;

//角色管理模块
@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	IRoleService roleService;

	@GetMapping("show")
	public String show(ModelMap modelmap){
		
		List<Role> allRoles=roleService.getAllRoles();
		
		modelmap.addAttribute("allRoles", allRoles);
		
		return "role/show";
	}
	
	@GetMapping("edit")
	public String show(){
		
		return "role/edit";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id){
		//删除角色
		roleService.delete(id);
		
		return "redirect:/role/show";
	}
}
