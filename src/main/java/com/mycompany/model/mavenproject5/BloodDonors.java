/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.mavenproject5;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yusuf
 */
@Entity
@Table(name = "blood_donors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BloodDonors.findAll", query = "SELECT b FROM BloodDonors b")
    , @NamedQuery(name = "BloodDonors.findByDonorsId", query = "SELECT b FROM BloodDonors b WHERE b.donorsId = :donorsId")
    , @NamedQuery(name = "BloodDonors.findByDonorsName", query = "SELECT b FROM BloodDonors b WHERE b.donorsName = :donorsName")
    , @NamedQuery(name = "BloodDonors.findByDonorsSurname", query = "SELECT b FROM BloodDonors b WHERE b.donorsSurname = :donorsSurname")
    , @NamedQuery(name = "BloodDonors.findByDonorsPhone", query = "SELECT b FROM BloodDonors b WHERE b.donorsPhone = :donorsPhone")
    , @NamedQuery(name = "BloodDonors.findByDonorsMail", query = "SELECT b FROM BloodDonors b WHERE b.donorsMail = :donorsMail")
    , @NamedQuery(name = "BloodDonors.findByDonorsLat", query = "SELECT b FROM BloodDonors b WHERE b.donorsLat = :donorsLat")
    , @NamedQuery(name = "BloodDonors.findByDonorsLng", query = "SELECT b FROM BloodDonors b WHERE b.donorsLng = :donorsLng")
    , @NamedQuery(name = "BloodDonors.findByDonorsPass", query = "SELECT b FROM BloodDonors b WHERE b.donorsPass = :donorsPass")
    , @NamedQuery(name = "BloodDonors.findByDonorsActive", query = "SELECT b FROM BloodDonors b WHERE b.donorsActive = :donorsActive")})
public class BloodDonors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "donors_id")
    private Integer donorsId;
    @Size(max = 45)
    @Column(name = "donors_name")
    private String donorsName;
    @Size(max = 45)
    @Column(name = "donors_surname")
    private String donorsSurname;
    @Size(max = 45)
    @Column(name = "donors_phone")
    private String donorsPhone;
    @Size(max = 45)
    @Column(name = "donors_mail")
    private String donorsMail;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "donors_lat")
    private Double donorsLat;
    @Column(name = "donors_lng")
    private Double donorsLng;
    @Size(max = 100)
    @Column(name = "donors_pass")
    private String donorsPass;
    @Column(name = "donors_active")
    private Short donorsActive;
    @JoinColumn(name = "bloodGroup_id", referencedColumnName = "bloodGroup_id")
    @ManyToOne
    private BloodGroup bloodGroupid;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne
    private Cities cityId;

    public BloodDonors() {
    }

    public BloodDonors(String donorsName, String donorsSurname, String donorsPhone, String donorsMail, Double donorsLat, Double donorsLng, String donorsPass, Short donorsActive, BloodGroup bloodGroupid, Cities cityId) {
        this.donorsName = donorsName;
        this.donorsSurname = donorsSurname;
        this.donorsPhone = donorsPhone;
        this.donorsMail = donorsMail;
        this.donorsLat = donorsLat;
        this.donorsLng = donorsLng;
        this.donorsPass = donorsPass;
        this.donorsActive = donorsActive;
        this.bloodGroupid = bloodGroupid;
        this.cityId = cityId;
    }
    
    public BloodDonors(Integer donorsId) {
        this.donorsId = donorsId;
    }

    public Integer getDonorsId() {
        return donorsId;
    }

    public void setDonorsId(Integer donorsId) {
        this.donorsId = donorsId;
    }

    public String getDonorsName() {
        return donorsName;
    }

    public void setDonorsName(String donorsName) {
        this.donorsName = donorsName;
    }

    public String getDonorsSurname() {
        return donorsSurname;
    }

    public void setDonorsSurname(String donorsSurname) {
        this.donorsSurname = donorsSurname;
    }

    public String getDonorsPhone() {
        return donorsPhone;
    }

    public void setDonorsPhone(String donorsPhone) {
        this.donorsPhone = donorsPhone;
    }

    public String getDonorsMail() {
        return donorsMail;
    }

    public void setDonorsMail(String donorsMail) {
        this.donorsMail = donorsMail;
    }

    public Double getDonorsLat() {
        return donorsLat;
    }

    public void setDonorsLat(Double donorsLat) {
        this.donorsLat = donorsLat;
    }

    public Double getDonorsLng() {
        return donorsLng;
    }

    public void setDonorsLng(Double donorsLng) {
        this.donorsLng = donorsLng;
    }

    public String getDonorsPass() {
        return donorsPass;
    }

    public void setDonorsPass(String donorsPass) {
        this.donorsPass = donorsPass;
    }

    public Short getDonorsActive() {
        return donorsActive;
    }

    public void setDonorsActive(Short donorsActive) {
        this.donorsActive = donorsActive;
    }

    public BloodGroup getBloodGroupid() {
        return bloodGroupid;
    }

    public void setBloodGroupid(BloodGroup bloodGroupid) {
        this.bloodGroupid = bloodGroupid;
    }

    public Cities getCityId() {
        return cityId;
    }

    public void setCityId(Cities cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donorsId != null ? donorsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloodDonors)) {
            return false;
        }
        BloodDonors other = (BloodDonors) object;
        if ((this.donorsId == null && other.donorsId != null) || (this.donorsId != null && !this.donorsId.equals(other.donorsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.mavenproject5.BloodDonors[ donorsId=" + donorsId + " ]";
    }
    
}
