package com.medicalabuseprevention.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicalabuseprevention.model.Prescription;
import com.medicalabuseprevention.model.User;

@RestController
public class UserController {

	private final static Logger logger = Logger.getLogger(PrescriptionController.class.getName());
	
	 @PersistenceContext
	    private EntityManager em;
   
   /*** Retrieve a single prescription ***/
   @RequestMapping(value="/user/{name}/{password}",produces="application/json", method=RequestMethod.GET)
   public List<User> authenticateUser(@PathVariable("name") String name, @PathVariable("password") String password)
   {
   	logger.info("authenticateUser: " + name + " -Psssword :" + password);
       List<User> user = em.createNamedQuery("fetchUserForAuth",User.class).setParameter("name", name).setParameter("password", password).getResultList();
       logger.info("getPrescriptionByVisitId: " + user);
       if(user!=null && user.size() > 0) {
       	logger.info("authenticateUser: " + user.size());
       }
       return user;
   }
	
}
