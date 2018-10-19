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

import com.bwf.entity.Affair;
import com.bwf.entity.AffairChain;
import com.bwf.entity.AffairModule;
import com.bwf.entity.User;
import com.bwf.service.IAffairChainService;
import com.bwf.service.IAffairModuleService;
import com.bwf.service.IAffairService;
import com.bwf.service.IModuleOptionService;

@RequestMapping("affair")
@Controller
public class AffairController {
	
	@Autowired
	IAffairModuleService affairModuleService;
	
	@Autowired
	IModuleOptionService moduleOptionService;

	@Autowired
	com.bwf.service.IAffairService affairService;
	
	@Autowired
	com.bwf.service.IAffairChainService affairChainService;



	@GetMapping("show")
	public String show(ModelMap modelMap , HttpSession session){
		User currentUser = (User) session.getAttribute("user");
		
		// 我发起的
		List<Affair> affairByMe =  affairService.getAffairByMe( currentUser );
		
		// 等我审批的
		List<Affair> affairToBePropose = affairService.getAffairToBePropose( currentUser );
		
		modelMap.addAttribute("affairByMe", affairByMe);
		modelMap.addAttribute("affairToBePropose", affairToBePropose);
		modelMap.addAttribute("affairModules", affairModuleService.getAll() );
		
		return "affair/show";
	}
	
	
	@GetMapping("detail/{id}")
	public String detail ( @PathVariable Integer id , ModelMap modelMap ) {
		
		
		Affair affair = affairService.getAffairDetailByAffairId( id );
		modelMap.addAttribute("affair", affair);
		
		return "affair/detail";
	}
	
	
	// 公文审批页面
	@GetMapping("propose/{id}")
	public String propose ( @PathVariable Integer id , ModelMap modelMap ) {		
		
		Affair affair = affairService.getAffairDetailByAffairId( id );
		modelMap.addAttribute("affair", affair);
		
		return "affair/propose";
	}
	
	// 公文审批保存
	@PostMapping("doPropose")
	public String doPropose ( AffairChain affairChain , String propose ){
		if( propose.equals("同意") ) {
			affairChain.setAffairChainStatus(2);
		} else {
			affairChain.setAffairChainStatus(3);
		}
		
		affairChainService.propose( affairChain );
		
		return "redirect:/affair/show";
	}
	
	@GetMapping("add")
	public String add( Integer affairModuleId , ModelMap modelMap){
		
		modelMap.addAttribute("moduleOptions", moduleOptionService.getModuleOptionsByAffairModuleId(affairModuleId)) ;
		modelMap.addAttribute("affairModuleId", affairModuleId);
		return "affair/add";
	}
	
	@GetMapping("doAdd")
	public String doAdd( Integer affairModuleId ,  String html , HttpSession session ){
		User currentUser = (User)session.getAttribute("user");
		
		com.bwf.entity.Affair affair = new Affair();
		AffairModule affairModule = new AffairModule();
		affairModule.setAffairModuleId(affairModuleId);
		affair.setAffairModule(affairModule);
		affair.setAffairData(html);
		affair.setProposer(  currentUser );
		affair.setAffairStatus(0);
		
		
		affairService.add( affair , currentUser );
		return "redirect:/affair/show";
	}
}
