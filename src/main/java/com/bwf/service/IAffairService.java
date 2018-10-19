package com.bwf.service;

import java.util.List;

import com.bwf.entity.Affair;
import com.bwf.entity.User;

public interface IAffairService {

	void add(Affair affair , User currentUser);

	List<Affair> getAffairByMe(User currentUser);

	Affair getAffairDetailByAffairId(Integer id);

	List<Affair> getAffairToBePropose(User currentUser);

}
