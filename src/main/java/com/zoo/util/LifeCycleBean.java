package com.zoo.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.zoo.model.User;
import com.zoo.service.user.UserService;

@Singleton
@Startup
public class LifeCycleBean {

	private static final String ADMIN_EMAIL = "admin@admin.com";
	private static final String ADMIN = "admin";
	private static final String ADMIN_AUTHORITY = "admin";
	
	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void init() {
		User admin = new User();
		admin.setEmail(ADMIN_EMAIL);
		admin.setFirstName(ADMIN);
		admin.setLastName(ADMIN);
		admin.setPass(ADMIN);
		admin.setAuthority(ADMIN_AUTHORITY);
		
		em.persist(admin);
	}

}
