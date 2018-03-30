/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.BloodDonors;
import com.mycompany.model.mavenproject5.BloodGroup;
import com.mycompany.model.mavenproject5.Cities;
import entitiyUtility.entityManagerUtility;
import java.util.ArrayList;
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
public class DonorsDAOImpl implements DonorsDAO{
    private EntityManager em;
    private EntityManagerFactory emf;

    public DonorsDAOImpl() 
    {
       emf=entityManagerUtility.emf;
        em=entityManagerUtility.em;
    }
    
    @Override
    public BloodDonors insertDonors(String donorsName, String donorsSurname, String donorsPhone, String donorsMail, Double donorsLat, Double donorsLng, String donorsPass,Short donorsActive, BloodGroup bloodGroupid, Cities cityId)
    {
        
        BloodDonors bd=new BloodDonors(donorsName, donorsSurname, donorsPhone, donorsMail,donorsLat,donorsLng,donorsPass,donorsActive,bloodGroupid,cityId);     
        em.getTransaction().begin();
        em.persist(bd);
        em.getTransaction().commit();
        return bd;
        
    }

    @Override
    public List<BloodDonors> findAllDonors() {
       
        TypedQuery<BloodDonors> query = em.createQuery("SELECT b FROM BloodDonors b", BloodDonors.class);
        List<BloodDonors> activeDonors=new ArrayList<BloodDonors>();
        for (BloodDonors bloodDonors : query.getResultList()) {
            if(bloodDonors.getDonorsActive()==1)
                activeDonors.add(bloodDonors);
        }
        return activeDonors;
    }
    @Override
    public BloodDonors findID(int donorsId) {
        return em.find(BloodDonors.class, donorsId);
    }

    @Override
    public void deleteAccount(int donorsId) {
       BloodDonors tempDonor=em.find(BloodDonors.class, donorsId);
       short passive=0;
       em.getTransaction().begin();
       tempDonor.setDonorsActive(passive);
       em.getTransaction().commit();
    }

    @Override
    public void updateAccount(BloodDonors UpdateDonor, int donorsId) {
       BloodDonors tempDonor=em.find(BloodDonors.class, donorsId);
       em.getTransaction().begin();
       tempDonor.setDonorsName(UpdateDonor.getDonorsName());
       tempDonor.setDonorsSurname(UpdateDonor.getDonorsSurname());
       tempDonor.setDonorsLat(UpdateDonor.getDonorsLat());
       tempDonor.setDonorsLng(UpdateDonor.getDonorsLng());
       tempDonor.setDonorsPass(UpdateDonor.getDonorsPass());
       tempDonor.setDonorsPhone(UpdateDonor.getDonorsPhone());
       tempDonor.setBloodGroupid(UpdateDonor.getBloodGroupid());
       tempDonor.setCityId(UpdateDonor.getCityId());
       em.getTransaction().commit();
    }

    @Override
    public BloodDonors mailQuery(String mail) {
        
        try 
        {
             Query query = em.createNamedQuery("BloodDonors.findByDonorsMail");
             query.setParameter("donorsMail", mail);
             return (BloodDonors) query.getSingleResult();
      
        } catch (Exception e) 
        {
            BloodDonors tempDonor=null;
            return tempDonor;
        }
    }

    @Override
    public void ResetPassword(String mail,String password) {
        
        Query query = em.createNamedQuery("BloodDonors.findByDonorsMail");
        query.setParameter("donorsMail", mail);
        BloodDonors tempDonor=(BloodDonors)query.getSingleResult();
        em.getTransaction().begin();
        tempDonor.setDonorsPass(password);
        em.getTransaction().commit();
        
    }
    
}
