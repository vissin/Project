package com.medicalabuseprevention.controller;

import com.medicalabuseprevention.model.Doctor;
import com.medicalabuseprevention.model.Patient;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicalabuseprevention.model.Prescription;
import com.medicalabuseprevention.requestdto.PrescriptionUpdateRequest;
import com.medicalabuseprevention.model.Visit;
import com.medicalabuseprevention.requestdto.VisitDTO;

import java.util.logging.Level;

@RestController
public class PrescriptionController {

  private final static Logger logger = Logger.getLogger(PrescriptionController.class.getName());

  @PersistenceContext
  private EntityManager em;

  /**
   * * Retrieve a single prescription
   *
   * @param visitId
   * @return  **
   */
  @RequestMapping(value = "/prescription/{visitid}", produces = "application/json", method = RequestMethod.GET)
  public VisitDTO getVisitDetailsByVisitId(@PathVariable("visitid") long visitId) {
    logger.log(Level.INFO, "getVisitDetailsByVisitId: {0}", visitId);
    VisitDTO visitDto = new VisitDTO();

    List<Prescription> prescription = em.createNamedQuery("findPrescriptionForVisitId", Prescription.class).setParameter("visitId", visitId).getResultList();
    visitDto.setPrescriptionDTO(prescription);

    Visit visit = em.createNamedQuery("findVisitById", Visit.class).setParameter("visitId", visitId).getSingleResult();
    visitDto.setVisitDTO(visit);

    Doctor doctor = em.createNamedQuery("findDoctorById", Doctor.class).setParameter("doctorId", visit.getDoctorId()).getSingleResult();
    visitDto.setDoctorDTO(doctor);

    Patient patient = em.createNamedQuery("findPatientById", Patient.class).setParameter("patId", visit.getPatientId()).getSingleResult();
    visitDto.setPatientDTO(patient);
    visitDto.setVisitId(visitId);

    logger.log(Level.INFO, "getVisitDetailsByVisitId: {0}", visitId);
    return visitDto;
  }

  /**
   * * Retrieve a single prescription
   *
   * @param pUpdateReqeust
   * @return  **
   */
  @Transactional(propagation = Propagation.REQUIRED)
  @RequestMapping(value = "/prescription/update", produces = "application/json", consumes="application/json", method = RequestMethod.PUT)
  public boolean updatePrescription(@RequestBody List<PrescriptionUpdateRequest> pUpdateReqeust) {
    for (PrescriptionUpdateRequest pRequest : pUpdateReqeust) {
	  System.out.println("updatePrescription-updatePrescription-updatePrescription-updatePrescription");
      Prescription prescription = em.createNamedQuery("findPrescriptionById", Prescription.class).setParameter("id", pRequest.getId()).getSingleResult();
      prescription.setProvided(pRequest.isProvided());
      em.merge(prescription);
    }
    return true;
  }

}
