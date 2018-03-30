/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.model.mavenproject5.Cities;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Yusuf
 */
public interface CitiesDAO {
    
    public List<Cities> findAll();
    public ArrayList<SelectItem> findAllSelectItem();
    public Cities findID(int id);
}
