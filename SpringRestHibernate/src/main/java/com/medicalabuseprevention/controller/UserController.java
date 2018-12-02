package com.medicalabuseprevention.controller;

import com.medicalabuseprevention.model.Chemist;
import com.medicalabuseprevention.model.Doctor;
import com.medicalabuseprevention.model.Patient;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicalabuseprevention.model.User;
import com.medicalabuseprevention.requestdto.UserDTO;
import com.medicalabuseprevention.requestdto.UserRequest;

import java.util.logging.Level;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

  private final static Logger logger = Logger.getLogger(PrescriptionController.class.getName());

  @PersistenceContext
  private EntityManager em;

  /**
   * * Retrieve a single prescription
   *
   * @param userRequest
   * @return **
   */
  @RequestMapping(value = "/user/login", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
  public UserDTO authenticateUser(@RequestBody UserRequest userRequest) {
    logger.log(Level.INFO, "authenticateUser: {0} -Psssword :{1}", new Object[]{userRequest.getUserId(), userRequest.getPassword()});
    UserDTO userDTO = new UserDTO();
    userDTO.setUserId(userRequest.getUserId());
    
    User user = null;
    
    try {
      user = em.createNamedQuery("fetchUserForAuth", User.class).setParameter("name", userRequest.getUserId()).setParameter("password", userRequest.getPassword()).getSingleResult();
      userDTO.setRole(user.getRole());

    } catch (Exception e) {
      logger.info("Error" + e);
      userDTO.setResult("Not Found");
    }
    
    if(user==null){
      logger.info("User not exists");
      userDTO.setResult("Not Found");
      return userDTO;
    }
    if (user.getRole().equalsIgnoreCase("D")) {
      try {
        Doctor doctor = em.createNamedQuery("findDoctorByUserId", Doctor.class).setParameter("userId", userRequest.getUserId()).getSingleResult();
        userDTO.setDoctor(doctor);
        userDTO.setResult("Success");
        return userDTO;
      } catch (Exception e) {
        logger.info("Error" + e);
        userDTO.setResult("Not Found");
      }
    }

    if (user.getRole().equalsIgnoreCase("C")) {
      try {
        Chemist chemist = em.createNamedQuery("findChemistByUserId", Chemist.class).setParameter("userId", userRequest.getUserId()).getSingleResult();
        userDTO.setChemist(chemist);
        userDTO.setResult("Success");
        return userDTO;
      } catch (Exception e) {
        logger.info("Error: " + e);
        userDTO.setResult("Not Found");
      }
    }

    if (user.getRole().equalsIgnoreCase("P")) {
      try {
        Patient patient = em.createNamedQuery("findPatientByUserId", Patient.class).setParameter("userId", userRequest.getUserId()).getSingleResult();
        userDTO.setPatient(patient);
        userDTO.setResult("Success");
        return userDTO;
      } catch (Exception e) {
        logger.info("Error: " + e);
        userDTO.setResult("Not Found");
      }
    }

    return userDTO;
  }
}
