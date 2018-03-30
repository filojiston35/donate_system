/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.BloodDonors;
import com.mycompany.model.mavenproject5.BloodGroup;
import com.mycompany.model.mavenproject5.Cities;
import java.util.List;

/**
 *
 * @author Yusuf
 */
public interface DonorsDAO {
    
     
     public BloodDonors insertDonors(String donorsName, String donorsSurname, String donorsPhone, String donorsMail, Double donorsLat, Double donorsLng, String donorsPass,Short donorsActive, BloodGroup bloodGroupid, Cities cityId);
     public List<BloodDonors> findAllDonors();
     public BloodDonors findID(int donorsId);
     public void deleteAccount(int donorsId);
     public void updateAccount(BloodDonors UpdateDonor,int donorsId);
     public BloodDonors mailQuery(String mail);
     public void ResetPassword(String mail,String password);
}
