package bean;



import com.mycompany.model.mavenproject5.BloodDonors;
import com.mycompany.model.mavenproject5.BloodGroup;
import com.mycompany.model.mavenproject5.Cities;
import dao.*;
import dao.DonorsDAOImpl;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import md5.HashPassword;
import org.primefaces.PrimeFaces;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import patientmail.Mail;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yusuf
 */
@ManagedBean
@RequestScoped
public class DonorsRegistration implements Serializable{
    /*Donors*/
    private String donors_name;
    private String donors_surname;
    private String donors_bloodGroup;  
    private String donors_mail;
    private String donors_phone;  
    private String donors_city;  
    
    /*Cities*/
    private List<SelectItem> citiesSelectItem;   
    private Cities city;
    private List<Cities> citiesDAO;
    private CitiesDAOImpl cityDAOImpl=new CitiesDAOImpl();
    
    /*BloodGroup*/
    private List<SelectItem> bloodGroupSelectItem;
    private BloodGroup bloodGroup;
    private List<BloodGroup> bloodGroupDAO;
    private BloodGroupDAOImpl bloodGroupDAOImpl=new BloodGroupDAOImpl();

    /*gmap*/
    private String title;     
    private double donors_lat;     
    private double donors_lng;
    private String pass;
    
    /*reset password*/
    private String donorsMailResetPassword;
    
    private DonorsDAOImpl donorsDAOImpl=new DonorsDAOImpl();

    @PostConstruct
    public void init()
    {      
       citiesDAO=new ArrayList<Cities>();
       citiesDAO=cityDAOImpl.findAll();
       citiesSelectItem=new ArrayList<SelectItem>();
       for(Cities tempCities:citiesDAO)
       {
           citiesSelectItem.add(new SelectItem(tempCities.getCityId(), tempCities.getCityName()));
       }
       
       bloodGroupDAO=new ArrayList<BloodGroup>();
       bloodGroupDAO=bloodGroupDAOImpl.findAll();
       bloodGroupSelectItem=new ArrayList<SelectItem>();
       for(BloodGroup tempBloodGrup:bloodGroupDAO)
       {
           bloodGroupSelectItem.add(new SelectItem(tempBloodGrup.getBloodGroupid(),tempBloodGrup.getBloodGroupName()));
       }
       
    }
    public void resetPassword() throws NoSuchAlgorithmException
    {
        BloodDonors tempDonor=donorsDAOImpl.mailQuery(donorsMailResetPassword);
        if(tempDonor==null)
        {
                FacesMessage message = null;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hatalı Bilgi !", "Böyle bir eposta adresi yok.");
                FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else
        {
            HashPassword hp=new HashPassword();
            String createKey=createKey();
            String md5pass=hp.HashPassword(createKey);
            donorsDAOImpl.ResetPassword(donorsMailResetPassword,md5pass);
            Mail sendMail=new Mail();            
            sendMail.resetPassword(createKey,donorsMailResetPassword);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Şifre sıfırlama başarılı",  "Geçici şifreniz epostanıza gönderilmiştir.") );
            PrimeFaces.current().ajax().addCallbackParam("resetPassword",true);
            FacesMessage message = null;
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
    public void DAO() throws IOException
    {
        city=cityDAOImpl.findID(Integer.parseInt(donors_city));
        bloodGroup=bloodGroupDAOImpl.findID(Integer.parseInt(donors_bloodGroup));
        
        HashPassword hp=new HashPassword();
        String md5pass = null;
        try 
        {
            md5pass=hp.HashPassword(pass);
            BloodDonors tempDonor=donorsDAOImpl.mailQuery(donors_mail);
        
            if(tempDonor==null)
            {
                donorsDAOImpl.insertDonors(donors_name, donors_surname,donors_phone,donors_mail,donors_lat,donors_lng,md5pass,(short)1,bloodGroup,city);
                FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
            }
            else
            {
                FacesMessage message = null;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hatalı Bilgi !", "Bu eposta adresi zaten kullanılıyor.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
      
            
        
    }

    public String getDonorsMailResetPassword() {
        return donorsMailResetPassword;
    }

    public void setDonorsMailResetPassword(String donorsMailResetPassword) {
        this.donorsMailResetPassword = donorsMailResetPassword;
    }
    
    public List<SelectItem> getBloodGroupSelectItem() {
        return bloodGroupSelectItem;
    }

    public void setBloodGroupSelectItem(List<SelectItem> bloodGroupSelectItem) {
        this.bloodGroupSelectItem = bloodGroupSelectItem;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDonors_lat() {
        return donors_lat;
    }

    public void setDonors_lat(double donors_lat) {
        this.donors_lat = donors_lat;
    }

    public double getDonors_lng() {
        return donors_lng;
    }

    public void setDonors_lng(double donors_lng) {
        this.donors_lng = donors_lng;
    }
    
    public List<SelectItem> getCitiesSelectItem() {
        return citiesSelectItem;
    }

    public void setCitiesSelectItem(List<SelectItem> citiesSelectItem) {
        this.citiesSelectItem = citiesSelectItem;
    }
    
    public String getDonors_city() {
        return donors_city;
    }

    public void setDonors_city(String donors_city) {
        this.donors_city = donors_city;
    }
    
    
    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public String getDonors_mail() {
        return donors_mail;
    }

    public void setDonors_mail(String donors_mail) {
        this.donors_mail = donors_mail;
    }

    public String getDonors_phone() {
        return donors_phone;
    }

    public void setDonors_phone(String donors_phone) {
        this.donors_phone = donors_phone;
    }
    
    public String getDonors_name() {
        return donors_name;
    }

    public void setDonors_name(String donors_name) {
        this.donors_name = donors_name;
    }

    public String getDonors_surname() {
        return donors_surname;
    }

    public void setDonors_surname(String donors_surname) {
        this.donors_surname = donors_surname;
    }

    public String getDonors_bloodGroup() {
        return donors_bloodGroup;
    }

    public void setDonors_bloodGroup(String donors_bloodGroup) {
        this.donors_bloodGroup = donors_bloodGroup;
    }

 
}
