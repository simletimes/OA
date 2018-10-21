package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.AffairModule;
import com.bwf.entity.AffairModuleChain;
import com.bwf.entity.ModuleOption;
import com.bwf.entity.User;
import com.bwf.service.IAffairModuleChainService;
import com.bwf.service.IModuleOptionService;


// 公文模板控制器 
@Controller
@RequestMapping("affair_module")
public class AffairModuleController {
	
	@Autowired
	com.bwf.service.IDepartmentService departmentService;
	
	@Autowired
	com.bwf.service.IAffairModuleService affairModuleService;

	@Autowired
	private com.bwf.service.IModuleOptionService moduleOptionService;

	@Autowired
	private com.bwf.service.IAffairModuleChainService affairModuleChainService;

	@GetMapping("show")
	public String show(ModelMap modelMap){
		List<AffairModule> affairModules = affairModuleService.getAll();
		modelMap.addAttribute("affairModules", affairModules);
		return "affair_module/show";
	}
	
	@GetMapping("add")
	public String add(ModelMap modelMap){
		
		modelMap.addAttribute("allDepartments", departmentService.getAllDepartment() ) ;
		return "affair_module/add";
	}
	
	@PostMapping("doAdd")
	public String doAdd( AffairModule affairModule , 
			String[] optionName , 
			Integer[] optionId , 
			String[] optionData ,
			Integer[] approverId ,
			HttpSession session
	) {
		
		User user = ( User ) session.getAttribute("user");
		affairModule.setAffairModuleProducerId( user.getUserId() );
		
		affairModuleService.add( affairModule ,optionName , optionId ,  optionData, approverId );
		
		return "redirect:/affair_module/show";
	}
	
	@GetMapping("edit/{id}")
	public String edit( @PathVariable("id") Integer id , ModelMap modelMap){
		AffairModule affairModule = affairModuleService.getAffairModuleById(id);
		List<ModuleOption> moduleOptions = moduleOptionService.getModuleOptionsByAffairModuleId(id);
		List<AffairModuleChain> affairModuleChains = affairModuleChainService.getAffairModuleChainsByAffairModuleId(id);
		
		
		modelMap.addAttribute("affairModule", affairModule);
		modelMap.addAttribute("moduleOptions", moduleOptions);
		modelMap.addAttribute("allDepartments", departmentService.getAllDepartment() ) ;
		modelMap.addAttribute("affairModuleChains", affairModuleChains);
		modelMap.addAttribute("id", id);
		
		return "affair_module/edit";
	}
	
	@PostMapping("doEdit/{id}")
	public String doEdit(  @PathVariable("id") Integer id  ){
		
		// 实现编辑模板功能
		return null;
	}
	
	
}
