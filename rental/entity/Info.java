/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rental.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STEINACOZ-PC
 */
@Entity
@Table(name = "info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i"),
    @NamedQuery(name = "Info.findById", query = "SELECT i FROM Info i WHERE i.id = :id"),
    @NamedQuery(name = "Info.findByCarname", query = "SELECT i FROM Info i WHERE i.carname = :carname"),
    @NamedQuery(name = "Info.findByCarmodel", query = "SELECT i FROM Info i WHERE i.carmodel = :carmodel"),
    @NamedQuery(name = "Info.findByManufacturer", query = "SELECT i FROM Info i WHERE i.manufacturer = :manufacturer"),
    @NamedQuery(name = "Info.findByYear", query = "SELECT i FROM Info i WHERE i.year = :year"),
    @NamedQuery(name = "Info.findByCategory", query = "SELECT i FROM Info i WHERE i.category = :category"),
    @NamedQuery(name = "Info.findByImage", query = "SELECT i FROM Info i WHERE i.image = :image"),
    @NamedQuery(name = "Info.findByPrice", query = "SELECT i FROM Info i WHERE i.price = :price"),
    @NamedQuery(name = "Info.findByAddeddate", query = "SELECT i FROM Info i WHERE i.addeddate = :addeddate"),
    @NamedQuery(name = "Info.findByHiredate", query = "SELECT i FROM Info i WHERE i.hiredate = :hiredate"),
    @NamedQuery(name = "Info.findByExpecteddate", query = "SELECT i FROM Info i WHERE i.expecteddate = :expecteddate"),
    @NamedQuery(name = "Info.findByAvailable", query = "SELECT i FROM Info i WHERE i.available = :available"),
    @NamedQuery(name = "Info.findByRef", query = "SELECT i FROM Info i WHERE i.ref = :ref")})
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    
  
  
    private Short id;
    
    private String carname;
    
    private String carmodel;
  
    private String manufacturer;
  
    private String year;
    
    private String category;
    
    private String image;
    
    private Float price;
    
   
    private Date addeddate;
    
    private Date hiredate;
    
    private Date expecteddate;
   
    private String available;
    
    private String ref;

   

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getExpecteddate() {
        return expecteddate;
    }

    public void setExpecteddate(Date expecteddate) {
        this.expecteddate = expecteddate;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rental.entity.Info[ id=" + id + " ]";
    }
    
}
