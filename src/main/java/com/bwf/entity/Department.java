package com.bwf.entity;

public class Department {
	
	private Integer deparmentId;
	
	private String departmentName;
	
	private Integer pid;
	
	private User leader;
	
	
	

	@Override
	public String toString() {
		return "Department [deparmentId=" + deparmentId + ", departmentName=" + departmentName + ", pid=" + pid
				+ ", leader=" + leader + "]";
	}

	public Integer getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(Integer deparmentId) {
		this.deparmentId = deparmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}
	
	
}
