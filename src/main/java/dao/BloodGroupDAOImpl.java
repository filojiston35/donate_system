/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.BloodGroup;
import entitiyUtility.entityManagerUtility;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Yusuf
 */
public class BloodGroupDAOImpl implements BloodGroupDAO{
    private EntityManager em;
    private EntityManagerFactory emf;

    public BloodGroupDAOImpl() {
       emf=entityManagerUtility.emf;
        em=entityManagerUtility.em;
    }
    
    
    @Override
    public List<BloodGroup> findAll() {
       TypedQuery<BloodGroup> query = em.createQuery("Select e from BloodGroup e", BloodGroup.class);
       return query.getResultList();
    }

    @Override
    public BloodGroup findID(int id) {
         return em.find(BloodGroup.class, id);
    }

    @Override
    public ArrayList<SelectItem> findAllSelectItem() {
        TypedQuery<BloodGroup> query = em.createQuery("Select e from BloodGroup e", BloodGroup.class);
        List<BloodGroup> bloodGroupList= query.getResultList();
        ArrayList<SelectItem> bloodGroupSelectItem=new ArrayList<SelectItem>();
        for (BloodGroup bloodGroup : bloodGroupList) {
             bloodGroupSelectItem.add(new SelectItem(bloodGroup.getBloodGroupid(),bloodGroup.getBloodGroupName()));
        }
        return bloodGroupSelectItem;
    }
    
}
