package com.registration.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.registration.model.Gender;
import com.registration.model.User;
import com.registration.service.Userservice;
import com.registration.bean.SessionScopeBean;

@ManagedBean
public class Userbean {
	
	private List<User> userlist ;
	private List<User> searchlist ;
	private User user;
	
	@EJB
	Userservice userservice;
	
	@ManagedProperty(value = "#{sessionScopeBean}")
	SessionScopeBean sessionScopeBean;
	
	@PostConstruct
	public void init() {
		userlist=new ArrayList<User>();
		userlist=userservice.getAllUserList();
		searchlist=new ArrayList<User>();
		user=new User();
		
	}
	
	public String saveUser() {
		userservice.saveuser(user);
		return "index?faces-redirect=true";
		
	}
    public String deleteUser(User user) {
    	userservice.deleteUser(user);
    	return "index?faces-redirect=true";
    }

    public String searchUser(User user) {
    	 
    	System.out.println("User bean : " + user);
    	
    	List<User> listuser= userservice.searchUser(user);
    	
    	sessionScopeBean.setUserList(listuser);
    	
    	for (User user2 : listuser) {
			System.out.println("Found user : " + user2);
		}
    	
    	
    	this.searchlist = listuser;
    	return "search?faces-redirect=true";    	
    }
    
    public Gender[] getGenders() {
    	return Gender.values();
    }
    
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public Userservice getUserservice() {
		return userservice;
	}

	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}

	public List<User> getSearchlist() {
		return searchlist;
	}

	public void setSearchlist(List<User> searchlist) {
		this.searchlist = searchlist;
	}

	public SessionScopeBean getSessionScopeBean() {
		return sessionScopeBean;
	}

	public void setSessionScopeBean(SessionScopeBean sessionScopeBean) {
		this.sessionScopeBean = sessionScopeBean;
	}

	
}
