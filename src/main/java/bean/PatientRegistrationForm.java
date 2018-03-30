/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.mycompany.model.mavenproject5.BloodGroup;
import com.mycompany.model.mavenproject5.Cities;
import com.mycompany.model.mavenproject5.Patient;
import dao.BloodGroupDAOImpl;
import dao.CitiesDAOImpl;
import dao.PatientDAOImpl;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.PrimeFaces;
import patientmail.Mail;
/**
 *
 * @author Yusuf
 */
@ManagedBean
public class PatientRegistrationForm implements Serializable{
    
    private String patientName;
    private String patientSurname;
    private String patientCity;
    private String patientBloodGroup;
    private String patientphone;
    private String patientInfo;
    private int patientDegreeOfUrgency;
    private String patientKey;
    private String patientMail;
    private PatientDAOImpl patientDAOImpl=new PatientDAOImpl();
    private Date patientDeadline;
    
    
    private List<SelectItem> bloodGroupSelectItem;
    private BloodGroup bloodGroup;
    private BloodGroupDAOImpl bloodGroupDAOImpl=new BloodGroupDAOImpl();;
    
    private List<SelectItem> citiesSelectItem;   
    private Cities city;
    private CitiesDAOImpl cityDAOImpl=new CitiesDAOImpl();
    @PostConstruct
    public void init()
    {

       bloodGroupSelectItem=new ArrayList<SelectItem>();
       bloodGroupSelectItem=bloodGroupDAOImpl.findAllSelectItem();
       
       
       citiesSelectItem=new ArrayList<SelectItem>();
       citiesSelectItem=cityDAOImpl.findAllSelectItem();
    }
    public void DAO(ActionEvent event)
    {
       
       city=cityDAOImpl.findID(Integer.parseInt(patientCity));             
       bloodGroup=bloodGroupDAOImpl.findID(Integer.parseInt(patientBloodGroup));
       Patient tempPatient=patientDAOImpl.mailQuery(patientMail);
       if(tempPatient==null)
       {
           patientKey=createKey();
           PrimeFaces.current().ajax().addCallbackParam("patientKey", patientKey);
           patientDeadline=new Date();
           patientDAOImpl.insertPatient(patientKey, patientName, patientSurname,patientphone, patientDegreeOfUrgency, patientInfo,(short)1,patientMail,patientDeadline,city,bloodGroup);
           Mail sendMail=new Mail(patientMail,patientName+" "+patientSurname, patientKey);
           sendMail.mailAt();
       }
       else
       {
            patientKey="";
            PrimeFaces.current().ajax().addCallbackParam("patientKey", patientKey);
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bu mail şuanda kullanılıyor.", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
       }
    }
    public String createKey()
    {
     String keyRepository="0123456789ABCDEFGHJKLMNPQRSTWXYZ";
       int repositoryLength=keyRepository.length();
       Random rnd = new Random();
       String key="";
       for(int i=1;i<=10;i++)
       {
           key+=keyRepository.charAt(rnd.nextInt(repositoryLength));
       }
        return key;
    }
    public String getPatientMail() {
        return patientMail;
    }

    public void setPatientMail(String patientMail) {
        this.patientMail = patientMail;
    }
    
    public String getPatientKey() {
        return patientKey;
    }

    public void setPatientKey(String patientKey) {
        this.patientKey = patientKey;
    }
    
    public int getPatientDegreeOfUrgency() {
        return patientDegreeOfUrgency;
    }

    public void setPatientDegreeOfUrgency(int patientDegreeOfUrgency) {
        this.patientDegreeOfUrgency = patientDegreeOfUrgency;
    }
    
    public List<SelectItem> getCitiesSelectItem() {
        return citiesSelectItem;
    }

    public void setCitiesSelectItem(List<SelectItem> citiesSelectItem) {
        this.citiesSelectItem = citiesSelectItem;
    }
    
    public List<SelectItem> getBloodGroupSelectItem() {
        return bloodGroupSelectItem;
    }

    public void setBloodGroupSelectItem(List<SelectItem> bloodGroupSelectItem) {
        this.bloodGroupSelectItem = bloodGroupSelectItem;
    }
    
    public String getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(String patientInfo) {
        this.patientInfo = patientInfo;
    }
    
    
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientBloodGroup() {
        return patientBloodGroup;
    }

    public void setPatientBloodGroup(String patientBloodGroup) {
        this.patientBloodGroup = patientBloodGroup;
    }

    public String getPatientphone() {
        return patientphone;
    }

    public void setPatientphone(String patientphone) {
        this.patientphone = patientphone;
    }
    
    
}
