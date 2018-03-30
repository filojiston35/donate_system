/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.mycompany.model.mavenproject5.BloodDonors;
import dao.BloodGroupDAOImpl;
import dao.DonorsDAOImpl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Yusuf
 */
@ManagedBean
@ViewScoped
public class MapBean implements Serializable{
    private final static MapModel emptyModel = new DefaultMapModel();
    private List<BloodDonors> bloodDonorsAll;
    private Marker marker;
    private Map donorInfo;
    private BloodDonors tempDonor;
    private DonorsDAOImpl donorsDAOImpl;
    @PostConstruct
    public void init()
    {      
        donorsDAOImpl =new DonorsDAOImpl();
        bloodDonorsAll=donorsDAOImpl.findAllDonors();
        
        donorInfo=new HashMap<Object,Object>();
        LatLng donorCoordinates;
        for(BloodDonors tempbloodDonor:bloodDonorsAll)
        {
            donorCoordinates=new LatLng(tempbloodDonor.getDonorsLng(),tempbloodDonor.getDonorsLat());
            emptyModel.addOverlay(new Marker(donorCoordinates,tempbloodDonor.getDonorsName()+" "+tempbloodDonor.getDonorsSurname(),tempbloodDonor));
            donorInfo.put(marker, tempbloodDonor.getDonorsId());
            
        }
    }
     public void onMarkerSelect(OverlaySelectEvent event) {
        marker=(Marker) event.getOverlay();
        bloodDonorInfo();
    }
 
    public void donorDetail(int donorId)
    {
        BloodDonors returnDonors=donorsDAOImpl.findID(donorId);
        PrimeFaces.current().ajax().addCallbackParam("donorMail",returnDonors.getDonorsMail());
        PrimeFaces.current().ajax().addCallbackParam("donorPhone",returnDonors.getDonorsPhone());
        PrimeFaces.current().ajax().addCallbackParam("donorId",returnDonors.getDonorsId());
    } 
    public MapModel getEmptyModel() {
        return emptyModel;
    }
   
    public void bloodDonorInfo()
    {      
        tempDonor=(BloodDonors)marker.getData();
    }

    public BloodDonors getTempDonor() {
        return tempDonor;
    }

    public void setTempDonor(BloodDonors tempDonor) {
        this.tempDonor = tempDonor;
    }

        
    
}
