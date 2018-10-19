package com.bwf.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairChainMapper;
import com.bwf.dao.AffairMapper;
import com.bwf.dao.AffairModuleChainMapper;
import com.bwf.dao.UserMapper;
import com.bwf.entity.Affair;
import com.bwf.entity.AffairChain;
import com.bwf.entity.AffairModuleChain;
import com.bwf.entity.User;
import com.bwf.service.IAffairService;

@Service
public class AffairServiceImpl implements IAffairService {
	
	@Autowired
	com.bwf.dao.AffairMapper affairMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	com.bwf.dao.AffairChainMapper affairChainMapper;
	
	@Autowired
	AffairModuleChainMapper affairModuleChainMapper;

	@Override
	public void add(Affair affair , User currentUser ) {
		// 往 公文表添加一条数据
		affairMapper.add( affair );
		
		// 获取 当前登录员工的上级
		User userWithLeader = userMapper.getUserWithLeader( currentUser );
		
		// 获取 AffairModuleChains 集合 
		List<AffairModuleChain> affairModuleChains
			= affairModuleChainMapper.getAffairModuleChainsByAffairModuleId( affair.getAffairModule().getAffairModuleId() );
				
		// 往 公文审批流程表中 添加 若干条数据	
		
		
		List<com.bwf.entity.AffairChain> affairChains = new ArrayList<AffairChain>();
		for( int i=0;i<affairModuleChains.size(); i++ ){
			AffairChain affairChain = new AffairChain();
			affairChain.setAffairId(  affair.getAffairId() );
			affairChain.setAffairChainOrder( i+1 );
			if (i==0) {
				affairChain.setAffairChainStatus(1);
			} else {
				affairChain.setAffairChainStatus(0);
			}
			if ( affairModuleChains.get(i).getApproverId()== -1 ) {
				// 设置为 当前已登录员工的 上级
				affairChain.setApprover( userWithLeader.getLeader().getUserId() ); 
			} else {
				// 就设置为当前值
				affairChain.setApprover( affairModuleChains.get(i).getApproverId() );
			}		
			
			affairChains.add(affairChain);
		}
		affairChainMapper.add ( affairChains );
	}

	@Override
	public List<Affair> getAffairByMe(User currentUser) {
		// TODO Auto-generated method stub
		return affairMapper.getAffairByMe( currentUser );
	}

	@Override
	public Affair getAffairDetailByAffairId(Integer id) {
		// TODO Auto-generated method stub
		Affair affair =  affairMapper.getAffairDetailByAffairId(id);
		
		for( AffairChain chain : affair.getAffairChains() ) {
			chain.setUser(  userMapper.getUserById( chain.getApprover() ) );
		}
		
		return affair;
	}

	@Override
	public List<Affair> getAffairToBePropose(User currentUser) {
		// TODO Auto-generated method stub
		return affairMapper.getAffairToBePropose( currentUser );
	}

}
