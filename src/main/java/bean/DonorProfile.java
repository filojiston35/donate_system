/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Yusuf
 */
@ManagedBean
@SessionScoped
public class DonorProfile implements Serializable{
    
    @ManagedProperty(value ="#{DonorsRegistration}")
    private DonorsRegistration donorsRegistrationBean;

    public void setDonorsRegistrationBean(DonorsRegistration donorsRegistrationBean) {
        this.donorsRegistrationBean = donorsRegistrationBean;
    }
    
    public String Guncelle()
    {
        return "../main.xhtml?faces-redirect=true";
    }
}
