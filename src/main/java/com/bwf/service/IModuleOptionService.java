package com.bwf.service;

import java.util.List;

import com.bwf.entity.ModuleOption;

public interface IModuleOptionService {

	List<ModuleOption> getModuleOptionsByAffairModuleId(Integer id);

}
