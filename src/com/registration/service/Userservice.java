package com.registration.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.registration.model.User;

@Stateless
public class Userservice {

	@PersistenceContext
	EntityManager enmanager;

	public void saveuser(User user) {

		enmanager.persist(user);
	}

	public List<User> getAllUserList() {
		List<User> users = enmanager.createQuery("SELECT u FROM User u ", User.class).getResultList();

		return users;
	}

	public void deleteUser(User user) {
		User deletedUser = enmanager.find(User.class, user.getId());
		enmanager.remove(deletedUser);
	}

	public List<User> searchUser(User user) {
		List<User> firstnameList = new ArrayList<User>();
		List<User> lastNameList = new ArrayList<User>();
		List<User> ageList = new ArrayList<User>();
		List<User> genderList = new ArrayList<User>();

		if(!user.getFirstname().isEmpty()) {
			firstnameList = enmanager.createQuery("SELECT u FROM User u WHERE u.firstname LIKE :first_name ", User.class)
					.setParameter("first_name", "%" + user.getFirstname()+"%").getResultList();
			return firstnameList;
		}else if(!user.getLastname().isEmpty()){
			lastNameList = enmanager.createQuery("SELECT u FROM User u WHERE u.lastname LIKE :lastname ",User.class)
			.setParameter("lastname", "%"+ user.getLastname()+"%").getResultList();
			return lastNameList;
			
			
		}
		

		return null;
	}

}
