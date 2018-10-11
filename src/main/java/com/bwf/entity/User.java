package com.bwf.entity;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class User {

	
	private int userId;
	
	@NotNull
	private String username;
	
	
	private String password;
	
	@Pattern(regexp="^[\u4e00-\u9fa5]{2,4}$")
	private String nickname;
	
	private String avater;
	
	private List<Menu> menus;
	
	private List<com.bwf.entity.Operate> operates;
	
	private User leader;
	

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", avater=" + avater + "]";
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public List<com.bwf.entity.Operate> getOperates() {
		return operates;
	}

	public void setOperates(List<com.bwf.entity.Operate> operates) {
		this.operates = operates;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getAvater() {
		return avater;
	}

	public void setAvater(String avater) {
		this.avater = avater;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}





	

	
}
