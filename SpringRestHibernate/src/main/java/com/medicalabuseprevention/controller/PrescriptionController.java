package com.medicalabuseprevention.controller;

import com.medicalabuseprevention.model.Doctor;
import com.medicalabuseprevention.model.Patient;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicalabuseprevention.model.Prescription;
import com.medicalabuseprevention.requestdto.PrescriptionUpdateRequest;
import com.medicalabuseprevention.model.Visit;
import com.medicalabuseprevention.requestdto.PrescriptionMedDTO;
import com.medicalabuseprevention.requestdto.VisitDTO;
import com.medicalabuseprevention.requestdto.VisitPrescriptionDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PrescriptionController {

	private final static Logger logger = Logger
			.getLogger(PrescriptionController.class.getName());

	@PersistenceContext
	private EntityManager em;

	/**
	 * * Retrieve a single prescription
	 *
	 * @param visitId
	 * @return **
	 */
	@RequestMapping(value = "/prescription/{visitid}", produces = "application/json", method = RequestMethod.GET)
	public VisitDTO getVisitDetailsByVisitId(
			@PathVariable("visitid") long visitId) {
		logger.log(Level.INFO, "getVisitDetailsByVisitId: {0}", visitId);
		VisitDTO visitDto = new VisitDTO();

		List<Prescription> prescription = em
				.createNamedQuery("findPrescriptionForVisitId",
						Prescription.class).setParameter("visitId", visitId)
				.getResultList();
		visitDto.setPrescriptionDTO(prescription);

		Visit visit = em.createNamedQuery("findVisitById", Visit.class)
				.setParameter("visitId", visitId).getSingleResult();
		visitDto.setVisitDTO(visit);

		Doctor doctor = em.createNamedQuery("findDoctorById", Doctor.class)
				.setParameter("doctorId", visit.getDoctorId())
				.getSingleResult();
		visitDto.setDoctorDTO(doctor);

		Patient patient = em.createNamedQuery("findPatientById", Patient.class)
				.setParameter("patId", visit.getPatientId()).getSingleResult();
		visitDto.setPatientDTO(patient);
		visitDto.setVisitId(visitId);

		logger.log(Level.INFO, "getVisitDetailsByVisitId: {0}", visitId);
		return visitDto;
	}

	/**
	 * * Retrieve a single prescription
	 *
	 * @param pUpdateReqeust
	 * @return **
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/prescription/update", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public boolean updatePrescription(
			@RequestBody List<PrescriptionUpdateRequest> pUpdateReqeust) {
		for (PrescriptionUpdateRequest pRequest : pUpdateReqeust) {
			System.out
					.println("updatePrescription-updatePrescription-updatePrescription-updatePrescription");
			Prescription prescription = em
					.createNamedQuery("findPrescriptionById",
							Prescription.class)
					.setParameter("id", pRequest.getId()).getSingleResult();
			prescription.setProvided(pRequest.isProvided());
			em.merge(prescription);
		}
		return true;
	}

	/**
	 * * Retrieve a single prescription
	 *
	 * @param addPrescriptionRequest
	 * @return **
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@RequestMapping(value = "/visit/update", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public boolean updateVisitDetails(
			@RequestBody VisitPrescriptionDTO addPrescriptionRequest) {
		logger.info("Tempsartue: "+ addPrescriptionRequest.getBloodPressure() + "|Rara" + addPrescriptionRequest.getTemprature());
		Visit visit = new Visit();
		visit.setBloodPressure(addPrescriptionRequest.getBloodPressure());
		visit.setDoctorId(addPrescriptionRequest.getDoctorId());
		visit.setHeight(addPrescriptionRequest.getHeight());
		visit.setPatientId(addPrescriptionRequest.getPatientId());
		visit.setPurchaseFlag(false);
		visit.setVisitDate(new Date().toLocaleString());
		visit.setWeight(addPrescriptionRequest.getWeight());
		visit.setTemperature(addPrescriptionRequest.getTemprature());
		BigInteger id = (BigInteger) em.createNativeQuery("select max(id)+1 as next_seq from visit").getSingleResult();
		//long id = Long.valueOf(String.valueOf(tuple[0]));
		visit.setId(id.longValue());
		System.out.println("NEW ID  :" + visit.getId());
		em.persist(visit);

		logger.log(Level.INFO, "Visit ID: {0}", visit.getId());
		if (!(addPrescriptionRequest.getMedicine()).isEmpty()) {
			for (PrescriptionMedDTO pmd : addPrescriptionRequest.getMedicine()) {
				Prescription pres = new Prescription();
				pres.setMedicine(pmd.getMedicine());
				pres.setProvided(false);
				pres.setDays(pmd.getDays());
				pres.setDosage(pmd.getDosage());
				pres.setTimes(pmd.getTimes());
				pres.setVisitId(visit.getId());
				BigInteger presId = (BigInteger) em.createNativeQuery("select max(id)+1 as next_seq from prescription").getSingleResult();
				//long id = Long.valueOf(String.valueOf(tuple[0]));
				pres.setId(presId.longValue());
				em.persist(pres);
			}
		}
		else {
			logger.info("Empty medicine");
		}
		return true;
	}

	/**
	 * * Retrieve a single patientDetails
	 *
	 * @param patientId
	 * @return **
	 */
	@RequestMapping(value = "/patient/{patientId}", produces = "application/json", method = RequestMethod.GET)
	public Patient getPatientDetailsByPatientId(
			@PathVariable("patientId") long patientId) {
		logger.log(Level.INFO, "getPatientDetailsByPatientId: {0}", patientId);
		Patient patient = null;
		try {
			patient = em.createNamedQuery("findPatientById", Patient.class)
					.setParameter("patId", patientId).getSingleResult();
		} catch (Exception e) {
			logger.log(Level.WARNING, "Not existed Patient" + patientId);
			patient = new Patient();
		}
		logger.log(Level.INFO, "getVisitDetailsByVisitId: {0}", patientId);
		return patient;
	}

	/**
	 * * Retrieve a patient history
	 * 
	 * @param patientId
	 * @return **
	 */
	@RequestMapping(value = "/patienthistory/{patientId}", produces = "application/json", method = RequestMethod.GET)
	public List<VisitDTO> getPatientHistoryByPatientId(
			@PathVariable("patientId") long patientId) {
		logger.log(Level.INFO, "getPatientDetailsByPatientId: {0}", patientId);

		List<VisitDTO> visitListDTO = new ArrayList<>();
		List<Visit> visit = em
				.createNamedQuery("findVisitByPatientId", Visit.class)
				.setParameter("patientId", patientId).getResultList();
		if (visit != null && !visit.isEmpty()) {
			for (Visit v : visit) {
				VisitDTO visitDto = new VisitDTO();
				visitDto.setVisitDTO(v);
				List<Prescription> prescription = em
						.createNamedQuery("findPrescriptionForVisitId",
								Prescription.class)
						.setParameter("visitId", v.getId())
						.getResultList();
				visitDto.setPrescriptionDTO(prescription);
				
		        Doctor doctor = em.createNamedQuery("findDoctorById", Doctor.class).setParameter("doctorId", v.getDoctorId()).getSingleResult();
		        visitDto.setDoctorDTO(doctor); 
				visitListDTO.add(visitDto);
			}
		}
		logger.log(Level.INFO, "getPatientDetailsByPatientId: {0}", patientId);
		return visitListDTO;
	}

	/**
	 * * Retrieve a single patientDetails
	 *
	 * @param doctorId
	 * @return **
	 */
	@RequestMapping(value = "/doctor/{doctorId}", produces = "application/json", method = RequestMethod.GET)
	public Doctor geDoctorDetailsByDoctorId(
			@PathVariable("doctorId") long doctorId) {
		logger.log(Level.INFO, "geDoctorDetailsByDoctorId: {0}", doctorId);
		Doctor doctor = em.createNamedQuery("findDoctorById", Doctor.class)
				.setParameter("doctorId", doctorId).getSingleResult();

		logger.log(Level.INFO, "getVisitDetailsByVisitId: {0}", doctorId);
		return doctor;
	}
}