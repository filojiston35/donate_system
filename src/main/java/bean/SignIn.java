/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.mycompany.model.mavenproject5.BloodDonors;
import com.mycompany.model.mavenproject5.BloodGroup;
import com.mycompany.model.mavenproject5.Cities;
import dao.BloodGroupDAOImpl;
import dao.CitiesDAOImpl;
import dao.DonorsDAOImpl;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import md5.HashPassword;


/**
 *
 * @author Yusuf
 */
@ManagedBean(name="SignIn")
@SessionScoped
public class SignIn implements Serializable{
    
    private String loginMail;
    private String loginPass;
    private BloodDonors bloodDonor;
    private boolean loggedIn=false;
    private String donors_newbloodGroup;
    private String donors_newcity;
    private String donors_newpass="";
    private CitiesDAOImpl cityDAOImpl=new CitiesDAOImpl();
    private BloodGroupDAOImpl bloodGroupDAOImpl=new BloodGroupDAOImpl();
    private DonorsDAOImpl donorsDAOImpl;
    private List<BloodDonors> bloodDonorsAll;
    @PostConstruct
    public void init()
    {
        donorsDAOImpl=new DonorsDAOImpl();
    }
    public void loginControl() throws IOException
    {
        bloodDonorsAll=donorsDAOImpl.findAllDonors();
        HashPassword hp=new HashPassword();
        for(BloodDonors tempDonor:bloodDonorsAll)
        {
            if(tempDonor.getDonorsMail().equals(loginMail))
            {
                try 
                {
                    if(tempDonor.getDonorsPass().equals(hp.HashPassword(loginPass)) && tempDonor.getDonorsActive()==1)
                    {
                        bloodDonor=tempDonor;
                        loggedIn=true;
                        break;
                    }
                } catch (NoSuchAlgorithmException e) {}                   
            }           
        }
        if(loggedIn==true)
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
        }
           
        else
        {
            FacesMessage message = null;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hatalı Bilgi !", "Lütfen kullanıcı adı ve şifrenizi kontrol ediniz.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    public void  updateAccount() throws IOException
    {
        
        Cities city=cityDAOImpl.findID(Integer.parseInt(donors_newcity));       
        BloodGroup bloodGroup=bloodGroupDAOImpl.findID(Integer.parseInt(donors_newbloodGroup));
        HashPassword hp=new HashPassword();
        try 
        {         
            bloodDonor.setBloodGroupid(bloodGroup);
            bloodDonor.setCityId(city);
            if(!donors_newpass.equals(""))
                bloodDonor.setDonorsPass(hp.HashPassword(donors_newpass));
            donorsDAOImpl.updateAccount(bloodDonor,bloodDonor.getDonorsId());          
        } 
        catch (Exception ex) {
        }
       FacesContext.getCurrentInstance().getExternalContext().redirect("donorProfile.xhtml");
        
    }
    public String deleteAccount()
    {
        donorsDAOImpl.deleteAccount(bloodDonor.getDonorsId());
        return "logout.xhtml?faces-redirect=true";
    }

    public String getDonors_newpass() {
        return donors_newpass;
    }

    public void setDonors_newpass(String donors_newpass) {
        this.donors_newpass = donors_newpass;
    }
    
    public String getDonors_newbloodGroup() {
        return donors_newbloodGroup;
    }

    public void setDonors_newbloodGroup(String donors_newbloodGroup) {
        this.donors_newbloodGroup = donors_newbloodGroup;
    }

    public String getDonors_newcity() {
        return donors_newcity;
    }

    public void setDonors_newcity(String donors_newcity) {
        this.donors_newcity = donors_newcity;
    }
    
    public BloodDonors getBloodDonor() {
        return bloodDonor;
    }

    public void setBloodDonor(BloodDonors bloodDonor) {
        this.bloodDonor = bloodDonor;
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String getLoginMail() {
        return loginMail;
    }

    public void setLoginMail(String loginMail) {
        this.loginMail = loginMail;
    }
    

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
 
}
