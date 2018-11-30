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
import java.util.logging.Level;

@RestController
public class UserController {

  private final static Logger logger = Logger.getLogger(PrescriptionController.class.getName());

  @PersistenceContext
  private EntityManager em;

  /**
   * * Retrieve a single prescription
   *
   * @param name
   * @param password
   * @return  **
   */
  @RequestMapping(value = "/user/{name}/{password}", produces = "application/json", method = RequestMethod.GET)
  public List<User> authenticateUser(@PathVariable("name") String name, @PathVariable("password") String password) {
    logger.log(Level.INFO, "authenticateUser: {0} -Psssword :{1}", new Object[]{name, password});
    List<User> user = em.createNamedQuery("fetchUserForAuth", User.class).setParameter("name", name).setParameter("password", password).getResultList();
    logger.log(Level.INFO, "getPrescriptionByVisitId: {0}", user);
    if (user != null && user.size() > 0) {
      logger.log(Level.INFO, "authenticateUser: {0}", user.size());
    }
    return user;
  }

}
