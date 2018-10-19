package com.bwf.service;

import java.util.List;

import com.bwf.entity.AffairModuleChain;

public interface IAffairModuleChainService {

	List<AffairModuleChain> getAffairModuleChainsByAffairModuleId(Integer id);

}
