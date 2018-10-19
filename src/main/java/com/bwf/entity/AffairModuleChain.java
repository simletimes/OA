package com.bwf.entity;

public class AffairModuleChain {
	private Integer affairModuleChainId;
	
	private Integer order;
	
	private Integer approverId;
	
	private Integer affairModuleId;
	
	private User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAffairModuleChainId() {
		return affairModuleChainId;
	}

	public void setAffairModuleChainId(Integer affairModuleChainId) {
		this.affairModuleChainId = affairModuleChainId;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getApproverId() {
		return approverId;
	}

	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}

	public Integer getAffairModuleId() {
		return affairModuleId;
	}

	public void setAffairModuleId(Integer affairModuleId) {
		this.affairModuleId = affairModuleId;
	}
	
	
}
