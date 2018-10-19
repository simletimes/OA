package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.ModuleOptionMapper;
import com.bwf.entity.ModuleOption;
import com.bwf.service.IModuleOptionService;

@Service
public class ModuleOptionServiceImpl implements IModuleOptionService{

	@Autowired
	com.bwf.dao.ModuleOptionMapper moduleOptionMapper;
	
	
	@Override
	public List<ModuleOption> getModuleOptionsByAffairModuleId(Integer id) {
		// TODO Auto-generated method stub
		return moduleOptionMapper.getModuleOptionsByAffairModuleId(id);
	}

}
