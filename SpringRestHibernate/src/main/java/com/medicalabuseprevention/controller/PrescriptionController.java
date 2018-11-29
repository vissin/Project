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

@RestController
public class PrescriptionController {
	
	private final static Logger logger = Logger.getLogger(PrescriptionController.class.getName());
	
	 @PersistenceContext
	    private EntityManager em;
    
    /*** Retrieve a single prescription ***/
    @RequestMapping(value="/prescription/{visitid}",produces="application/json", method=RequestMethod.GET)
    public List<Prescription> getPrescriptionByVisitId(@PathVariable("visitid") long visitId)
    {
    	logger.info("getPrescriptionByVisitId: " + visitId);
        List<Prescription> prescription = em.createNamedQuery("findPrescriptionForVisitId",Prescription.class).setParameter("visitId", visitId).getResultList();
        logger.info("getPrescriptionByVisitId: " + prescription);
        if(prescription!=null && prescription.size() > 0) {
        	logger.info("getPrescriptionByVisitId: " + prescription.size());
        }
        return prescription;
    }
    
    /*** Update a Student ***/
   /* @RequestMapping(value="/update", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateStudent(@RequestBody Student student)
    {
        studentDAOImpl.updateStudent(student);
    }*/

}
