/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.mycompany.model.mavenproject5.BloodDonors;
import com.mycompany.model.mavenproject5.Patient;
import dao.BloodGroupDAOImpl;
import dao.CitiesDAOImpl;
import dao.DonorsDAOImpl;
import dao.PatientDAOImpl;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Yusuf
 */
@ManagedBean
@ViewScoped
public class contentPage implements Serializable{
    private PatientDAOImpl patientDAOImpl;
    private List<Patient> patients;
    
    private List<Patient> degreeOfUrgency1;
    private List<Patient> degreeOfUrgency2;
    private List<Patient> degreeOfUrgency3;
    
    private DonorsDAOImpl donorsDAOImpl;
    private List<BloodDonors> bloodDonorsAll;
    private List<BloodDonors> bloodDonorFilterList;
    
    private boolean lessThan24=false;
    private boolean Hours24=false;
    private boolean moreThan24=false;
    
    private List<SelectItem> bloodGroupSelectItem;
    private BloodGroupDAOImpl bloodGroupDAOImpl=new BloodGroupDAOImpl();;
    private CitiesDAOImpl cityDAOImpl=new CitiesDAOImpl();
    private List<SelectItem> citiesSelectItem;  
    
    private String filterCity;
    private String  filterBloodGroup;
    @PostConstruct
    public void init() {
        donorsDAOImpl=new DonorsDAOImpl();
        bloodDonorsAll=donorsDAOImpl.findAllDonors();
        bloodDonorFilterList=new ArrayList<BloodDonors>();
        
        patientDAOImpl=new PatientDAOImpl();
        patients=patientDAOImpl.findAllPatient();
        
        degreeOfUrgency1=new ArrayList<Patient>();
        degreeOfUrgency2=new ArrayList<Patient>();
        degreeOfUrgency3=new ArrayList<Patient>();
        
        bloodGroupSelectItem=bloodGroupDAOImpl.findAllSelectItem();
        citiesSelectItem=cityDAOImpl.findAllSelectItem();
        degreeOfUrgency();
        donorList();
        
    }
    public void patientDetail(int patientId)
    {
        Patient tempPatient=patientDAOImpl.findID(patientId);
        PrimeFaces.current().ajax().addCallbackParam("patientId",patientId);
         PrimeFaces.current().ajax().addCallbackParam("patientmail",tempPatient.getPatientMail());
         PrimeFaces.current().ajax().addCallbackParam("patientphone",tempPatient.getPatientPhone());
         PrimeFaces.current().ajax().addCallbackParam("patientinfo",tempPatient.getPatientInfo());
    }
    public void degreeOfUrgency()
    {
        for (Patient patient : patients) {
            
            if(patient.getPatientdegreeOfUrgency()==1)
            {
                degreeOfUrgency1.add(patient);
                lessThan24=true;
            }
                
            else if(patient.getPatientdegreeOfUrgency()==2)
            {
                degreeOfUrgency2.add(patient);
                Hours24=true;
            } 
            else if(patient.getPatientdegreeOfUrgency()==3)
            {
                degreeOfUrgency3.add(patient);
                moreThan24=true;
            }
                 
        }
    }
    public void filterDonorList() throws IOException
    {
        bloodDonorFilterList.clear();
        bloodDonorsAll=donorsDAOImpl.findAllDonors();
        if(filterBloodGroup!=null && filterCity!=null)
        {
          for (BloodDonors bloodDonors : bloodDonorsAll) 
          {
            if(bloodDonors.getBloodGroupid().getBloodGroupid().equals(Integer.parseInt(filterBloodGroup)) && bloodDonors.getCityId().getCityId().equals(Integer.parseInt(filterCity)))
                bloodDonorFilterList.add(bloodDonors);
          }
        }
        else if(filterBloodGroup!=null)
        {
        for (BloodDonors bloodDonors : bloodDonorsAll) 
          {
            if(bloodDonors.getBloodGroupid().getBloodGroupid().equals(Integer.parseInt(filterBloodGroup)))
                bloodDonorFilterList.add(bloodDonors);
          }
        }
        else if(filterCity!=null)
        {
        for (BloodDonors bloodDonors : bloodDonorsAll) 
          {
            if(bloodDonors.getCityId().getCityId().equals(Integer.parseInt(filterCity)))
                bloodDonorFilterList.add(bloodDonors);
          }
        }
        else
            donorList();
          
    }
    public void donorList()
    {

        bloodDonorFilterList=donorsDAOImpl.findAllDonors();
    }
    public void donorDetail(int donorId)
    {
        BloodDonors tempDonor=donorsDAOImpl.findID(donorId);
        String donorNameSurname=tempDonor.getDonorsName().toUpperCase()+" "+tempDonor.getDonorsSurname().toUpperCase();
        PrimeFaces.current().ajax().addCallbackParam("donorNameSurname",donorNameSurname);
        PrimeFaces.current().ajax().addCallbackParam("donorBloodGroup",tempDonor.getBloodGroupid().getBloodGroupName());
         PrimeFaces.current().ajax().addCallbackParam("donorCity",tempDonor.getCityId().getCityName());
        PrimeFaces.current().ajax().addCallbackParam("donorMail",tempDonor.getDonorsMail());
        PrimeFaces.current().ajax().addCallbackParam("donorPhone",tempDonor.getDonorsPhone());
    }

    public String getFilterCity() {
        return filterCity;
    }

    public void setFilterCity(String filterCity) {
        this.filterCity = filterCity;
    }

    public String getFilterBloodGroup() {
        return filterBloodGroup;
    }

    public void setFilterBloodGroup(String filterBloodGroup) {
        this.filterBloodGroup = filterBloodGroup;
    }
    
    public List<SelectItem> getBloodGroupSelectItem() {
        return bloodGroupSelectItem;
    }

    public void setBloodGroupSelectItem(List<SelectItem> bloodGroupSelectItem) {
        this.bloodGroupSelectItem = bloodGroupSelectItem;
    }

    public List<SelectItem> getCitiesSelectItem() {
        return citiesSelectItem;
    }

    public void setCitiesSelectItem(List<SelectItem> citiesSelectItem) {
        this.citiesSelectItem = citiesSelectItem;
    }
    
    public boolean isLessThan24() {
        return lessThan24;
    }

    public void setLessThan24(boolean lessThan24) {
        this.lessThan24 = lessThan24;
    }

    public boolean isHours24() {
        return Hours24;
    }

    public void setHours24(boolean Hours24) {
        this.Hours24 = Hours24;
    }

    public boolean isMoreThan24() {
        return moreThan24;
    }

    public void setMoreThan24(boolean moreThan24) {
        this.moreThan24 = moreThan24;
    }
    
    public List<BloodDonors> getBloodDonorFilterList() {
        return bloodDonorFilterList;
    }

    public void setBloodDonorFilterList(List<BloodDonors> bloodDonorFilterList) {
        this.bloodDonorFilterList = bloodDonorFilterList;
    }
    
    public List<Patient> getDegreeOfUrgency1() {
        return degreeOfUrgency1;
    }

    public void setDegreeOfUrgency1(List<Patient> degreeOfUrgency1) {
        this.degreeOfUrgency1 = degreeOfUrgency1;
    }

    public List<Patient> getDegreeOfUrgency2() {
        return degreeOfUrgency2;
    }

    public void setDegreeOfUrgency2(List<Patient> degreeOfUrgency2) {
        this.degreeOfUrgency2 = degreeOfUrgency2;
    }

    public List<Patient> getDegreeOfUrgency3() {
        return degreeOfUrgency3;
    }

    public void setDegreeOfUrgency3(List<Patient> degreeOfUrgency3) {
        this.degreeOfUrgency3 = degreeOfUrgency3;
    }
    
    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
    
    
    
}
