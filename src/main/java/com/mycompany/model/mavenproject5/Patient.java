/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.mavenproject5;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yusuf
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByPatientId", query = "SELECT p FROM Patient p WHERE p.patientId = :patientId")
    , @NamedQuery(name = "Patient.findByPatientKey", query = "SELECT p FROM Patient p WHERE p.patientKey = :patientKey")
    , @NamedQuery(name = "Patient.findByPatientName", query = "SELECT p FROM Patient p WHERE p.patientName = :patientName")
    , @NamedQuery(name = "Patient.findByPatientSurname", query = "SELECT p FROM Patient p WHERE p.patientSurname = :patientSurname")
    , @NamedQuery(name = "Patient.findByPatientPhone", query = "SELECT p FROM Patient p WHERE p.patientPhone = :patientPhone")
    , @NamedQuery(name = "Patient.findByPatientdegreeOfUrgency", query = "SELECT p FROM Patient p WHERE p.patientdegreeOfUrgency = :patientdegreeOfUrgency")
    , @NamedQuery(name = "Patient.findByPatientInfo", query = "SELECT p FROM Patient p WHERE p.patientInfo = :patientInfo")
    , @NamedQuery(name = "Patient.findByPatientActive", query = "SELECT p FROM Patient p WHERE p.patientActive = :patientActive")
    , @NamedQuery(name = "Patient.findByPatientMail", query = "SELECT p FROM Patient p WHERE p.patientMail = :patientMail")
    , @NamedQuery(name = "Patient.findByPatientDeadline", query = "SELECT p FROM Patient p WHERE p.patientDeadline = :patientDeadline")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id")
    private Integer patientId;
    @Size(max = 45)
    @Column(name = "patient_key")
    private String patientKey;
    @Size(max = 45)
    @Column(name = "patient_name")
    private String patientName;
    @Size(max = 45)
    @Column(name = "patient_surname")
    private String patientSurname;
    @Size(max = 45)
    @Column(name = "patient_phone")
    private String patientPhone;
    @Column(name = "patient_degreeOfUrgency")
    private Integer patientdegreeOfUrgency;
    @Size(max = 250)
    @Column(name = "patient_info")
    private String patientInfo;
    @Column(name = "patient_active")
    private Short patientActive;
    @Size(max = 45)
    @Column(name = "patient_mail")
    private String patientMail;
    @Column(name = "patient_deadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patientDeadline;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne
    private Cities cityId;
    @JoinColumn(name = "bloodGroup_id", referencedColumnName = "bloodGroup_id")
    @ManyToOne
    private BloodGroup bloodGroupid;

    public Patient() {
    }

    public Patient(String patientKey, String patientName, String patientSurname, String patientPhone, Integer patientdegreeOfUrgency, String patientInfo, Short patientActive, String patientMail, Date patientDeadline, Cities cityId, BloodGroup bloodGroupid) {
        this.patientKey = patientKey;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientPhone = patientPhone;
        this.patientdegreeOfUrgency = patientdegreeOfUrgency;
        this.patientInfo = patientInfo;
        this.patientActive = patientActive;
        this.patientMail = patientMail;
        this.patientDeadline = patientDeadline;
        this.cityId = cityId;
        this.bloodGroupid = bloodGroupid;
    }
    
    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientKey() {
        return patientKey;
    }

    public void setPatientKey(String patientKey) {
        this.patientKey = patientKey;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public Integer getPatientdegreeOfUrgency() {
        return patientdegreeOfUrgency;
    }

    public void setPatientdegreeOfUrgency(Integer patientdegreeOfUrgency) {
        this.patientdegreeOfUrgency = patientdegreeOfUrgency;
    }

    public String getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(String patientInfo) {
        this.patientInfo = patientInfo;
    }

    public Short getPatientActive() {
        return patientActive;
    }

    public void setPatientActive(Short patientActive) {
        this.patientActive = patientActive;
    }

    public String getPatientMail() {
        return patientMail;
    }

    public void setPatientMail(String patientMail) {
        this.patientMail = patientMail;
    }

    public Date getPatientDeadline() {
        return patientDeadline;
    }

    public void setPatientDeadline(Date patientDeadline) {
        this.patientDeadline = patientDeadline;
    }

    public Cities getCityId() {
        return cityId;
    }

    public void setCityId(Cities cityId) {
        this.cityId = cityId;
    }

    public BloodGroup getBloodGroupid() {
        return bloodGroupid;
    }

    public void setBloodGroupid(BloodGroup bloodGroupid) {
        this.bloodGroupid = bloodGroupid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.mavenproject5.Patient[ patientId=" + patientId + " ]";
    }
    
}
