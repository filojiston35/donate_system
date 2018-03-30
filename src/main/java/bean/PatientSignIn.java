/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.mycompany.model.mavenproject5.Patient;
import dao.PatientDAOImpl;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yusuf
 */
@ManagedBean
@SessionScoped
public class PatientSignIn {
    
    private String patientKey;
    private String result;
    private Patient patient;
    private boolean isLogged=false;
    private PatientDAOImpl patientDAOImpl;
    
    @PostConstruct
    public void init()
    {
        patientDAOImpl=new PatientDAOImpl();
        oldCallsDelete();
    }
    public String DAO()
    {
      patient=patientDAOImpl.findPatientKey(patientKey);
      if(patient==null)
      {
        result="Giriş işlemi başarısız";
      }
          
      else if(patient!=null)
      {
          result="Giriş işlemi başarılı";
          isLogged=true;
      }
              
        return "main.xhtml?faces-redirect=true";
    }
    public void oldCallsDelete()
    {
        List<Patient> allPatients=patientDAOImpl.findAllPatient();
        Date deadLine;
        for (Patient tempPatient : allPatients) {
            
            deadLine=tempPatient.getPatientDeadline();
            Date DateNow=new Date();
            Long differenceHours=TimeUnit.MILLISECONDS.toHours(DateNow.getTime()-deadLine.getTime());
            String deneme="";
            if(tempPatient.getPatientdegreeOfUrgency()==1 && differenceHours>24)
                patientDAOImpl.patientDelete(tempPatient.getPatientId());
            else if(tempPatient.getPatientdegreeOfUrgency()==2 && differenceHours>24)
                patientDAOImpl.patientDelete(tempPatient.getPatientId());
            else if(tempPatient.getPatientdegreeOfUrgency()==3 && differenceHours>48)
                patientDAOImpl.patientDelete(tempPatient.getPatientId());
        }
    }
    public String logOut()
    {
         FacesContext facesContext = FacesContext.getCurrentInstance();
         HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
         session.removeAttribute("patientSignIn");
         return "main.xhtml?faces-redirect=true";
    }
    public String endCall()
    {
        patientDAOImpl.patientDelete(patient.getPatientId());
        return logOut();
    }
    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public String getPatientKey() {
        return patientKey;
    }

    public void setPatientKey(String patientKey) {
        this.patientKey = patientKey;
    }
            
}
