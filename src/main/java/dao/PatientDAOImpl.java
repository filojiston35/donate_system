/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.BloodGroup;
import com.mycompany.model.mavenproject5.Cities;
import com.mycompany.model.mavenproject5.Patient;
import entitiyUtility.entityManagerUtility;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Yusuf
 */
public class PatientDAOImpl implements PatientDAO{
    private EntityManager em;
    private EntityManagerFactory emf;

    public PatientDAOImpl() {
        emf=entityManagerUtility.emf;
        em=entityManagerUtility.em;
    }
    
    
    @Override
    public Patient insertPatient(String patientKey, String patientName, String patientSurname, String patientPhone, Integer patientdegreeOfUrgency, String patientInfo, Short patientActive, String patientMail, Date patientDeadline, Cities cityId, BloodGroup bloodGroupid) {
      
        Patient patient=new Patient( patientKey,  patientName,  patientSurname,  patientPhone, patientdegreeOfUrgency, patientInfo, patientActive, patientMail, patientDeadline, cityId, bloodGroupid);       
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        return patient;
    }

    @Override
    public List<Patient> findAllPatient() {
        TypedQuery<Patient> query = em.createQuery("SELECT b FROM Patient b", Patient.class);
        return query.getResultList();
    }

    @Override
    public Patient mailQuery(String mail) {
         try 
        {
             Query query = em.createNamedQuery("Patient.findByPatientMail");
             query.setParameter("patientMail", mail);
             return (Patient) query.getSingleResult();
      
        } catch (Exception e) 
        {
            Patient tempPatient=null;
            return tempPatient;
        }
    }

    @Override
    public Patient findID(int id) {
        return em.find(Patient.class, id);
    }

    @Override
    public Patient findPatientKey(String patientKey) {
        try 
        {
             Query query = em.createNamedQuery("Patient.findByPatientKey");
             query.setParameter("patientKey", patientKey);
             return (Patient) query.getSingleResult();
      
        } catch (Exception e) 
        {
            Patient tempPatient=null;
            return tempPatient;
        }
    }

    @Override
    public void patientDelete(int patientId) {
        em.getTransaction().begin();
        em.remove(findID(patientId));
        em.getTransaction().commit();
    }
    
}
