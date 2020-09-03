package com.registration.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.registration.model.User;

@ManagedBean
@SessionScoped
public class SessionScopeBean {
	
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
	
	
	
	
}
