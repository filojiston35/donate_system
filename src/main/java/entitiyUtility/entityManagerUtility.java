/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiyUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Yusuf
 */
public class entityManagerUtility {
     public static EntityManagerFactory emf=Persistence.createEntityManagerFactory("donorsJPA");
     public static EntityManager em=emf.createEntityManager();
}
