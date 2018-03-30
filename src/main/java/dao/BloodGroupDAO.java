/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.BloodGroup;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Yusuf
 */
public interface BloodGroupDAO {
    
    public List<BloodGroup> findAll();
    public ArrayList<SelectItem> findAllSelectItem();
    public BloodGroup findID(int id);
}
