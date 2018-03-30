/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.Cities;
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
public class CitiesDAOImpl implements CitiesDAO{
    private EntityManager em;
    private EntityManagerFactory emf;

    public CitiesDAOImpl() {
       emf=entityManagerUtility.emf;
        em=entityManagerUtility.em;
    }
    
    @Override
    public List<Cities> findAll() {
      
       TypedQuery<Cities> query = em.createQuery("Select e from Cities e", Cities.class);
       return query.getResultList();
    }

    @Override
    public Cities findID(int id) {
      
       return em.find(Cities.class, id);
    }
     @Override
    public ArrayList<SelectItem> findAllSelectItem() {
        
        TypedQuery<Cities> query = em.createQuery("Select e from Cities e", Cities.class);
        List<Cities> citiesList= query.getResultList();
        ArrayList<SelectItem> citiesSelectItem=new ArrayList<SelectItem>();
         for (Cities cities : citiesList) {
             
             citiesSelectItem.add(new SelectItem(cities.getCityId(), cities.getCityName()));
         }
         return citiesSelectItem;
       
    }
    
}
