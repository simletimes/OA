package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairModuleChainMapper;
import com.bwf.entity.AffairModuleChain;
import com.bwf.service.IAffairModuleChainService;


@Service
public class AffairModuleChainServiceImpl implements IAffairModuleChainService {
	
	@Autowired
	AffairModuleChainMapper affairModuleChainMapper;

	@Override
	public List<AffairModuleChain> getAffairModuleChainsByAffairModuleId(Integer id) {
		// TODO Auto-generated method stub
		return affairModuleChainMapper.getAffairModuleChainsByAffairModuleId(id);
	}

}
