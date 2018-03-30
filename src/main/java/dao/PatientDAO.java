/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.BloodGroup;
import com.mycompany.model.mavenproject5.Cities;
import com.mycompany.model.mavenproject5.Patient;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Yusuf
 */
public interface PatientDAO {
     
     public Patient insertPatient(String patientKey, String patientName, String patientSurname, String patientPhone, Integer patientdegreeOfUrgency, String patientInfo, Short patientActive, String patientMail, Date patientDeadline, Cities cityId, BloodGroup bloodGroupid);
     public List<Patient> findAllPatient();
     public Patient mailQuery(String mail);
     public Patient findID(int id);
     public Patient findPatientKey(String patientKey);
     public void patientDelete(int patientId);
}
