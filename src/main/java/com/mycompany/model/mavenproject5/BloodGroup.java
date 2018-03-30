/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.mavenproject5;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yusuf
 */
@Entity
@Table(name = "blood_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BloodGroup.findAll", query = "SELECT b FROM BloodGroup b")
    , @NamedQuery(name = "BloodGroup.findByBloodGroupid", query = "SELECT b FROM BloodGroup b WHERE b.bloodGroupid = :bloodGroupid")
    , @NamedQuery(name = "BloodGroup.findByBloodGroupName", query = "SELECT b FROM BloodGroup b WHERE b.bloodGroupName = :bloodGroupName")})
public class BloodGroup implements Serializable {

    @OneToMany(mappedBy = "bloodGroupid")
    private Collection<Patient> patientCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bloodGroup_id")
    private Integer bloodGroupid;
    @Size(max = 45)
    @Column(name = "bloodGroupName")
    private String bloodGroupName;
    @OneToMany(mappedBy = "bloodGroupid")
    private Collection<BloodDonors> bloodDonorsCollection;

    public BloodGroup() {
    }

    public BloodGroup(Integer bloodGroupid) {
        this.bloodGroupid = bloodGroupid;
    }

    public Integer getBloodGroupid() {
        return bloodGroupid;
    }

    public void setBloodGroupid(Integer bloodGroupid) {
        this.bloodGroupid = bloodGroupid;
    }

    public String getBloodGroupName() {
        return bloodGroupName;
    }

    public void setBloodGroupName(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    @XmlTransient
    public Collection<BloodDonors> getBloodDonorsCollection() {
        return bloodDonorsCollection;
    }

    public void setBloodDonorsCollection(Collection<BloodDonors> bloodDonorsCollection) {
        this.bloodDonorsCollection = bloodDonorsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bloodGroupid != null ? bloodGroupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloodGroup)) {
            return false;
        }
        BloodGroup other = (BloodGroup) object;
        if ((this.bloodGroupid == null && other.bloodGroupid != null) || (this.bloodGroupid != null && !this.bloodGroupid.equals(other.bloodGroupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.mavenproject5.BloodGroup[ bloodGroupid=" + bloodGroupid + " ]";
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }
    
}
