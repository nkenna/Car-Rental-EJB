/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rental.bean;

import com.rental.entity.Info;
import com.rental.remoteinterace.rentalRemote;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author STEINACOZ-PC
 */
@Stateless
public class rentalBean implements rentalRemote{

    public rentalBean() {
    }
    
    @PersistenceContext(unitName="CarRental-ejbPU")
    private EntityManager em;
    Random rad = new Random();
    String status;
    
    String carName, carModel, carCategory, carImage, carYear;
    float carPrice;
    
     @Override
    public void addNewCar(String carName, String model, String available, String category, String FilePath, String manu, String price, String year) {
       
Info info = new Info();        
//generate catalogue Number
        String a = String.valueOf(rad.nextInt(9));
        String b = String.valueOf(rad.nextInt(9));
        String c = String.valueOf(rad.nextInt(9));
        String d = String.valueOf(rad.nextInt(9));
        String e = String.valueOf(rad.nextInt(9));
        String f = String.valueOf(rad.nextInt(9));
        
        String generatedNum = a + b + c + d + e + f + "-" + model.substring(0, 2);
       
        
        //persist
       
       info.setCarname(carName);
       info.setCarmodel(model);
       info.setAvailable(available);
       info.setCategory(category);
       info.setImage(FilePath);
       info.setManufacturer(manu);
       info.setPrice(Float.parseFloat(price));
       info.setYear(year);
        
        info.setRef(generatedNum);
      info.setExpecteddate(new Date());
        info.setAddeddate(new Date());
        em.persist(info);
        em.flush();
        status = "Operation successful";
        setStatusMsg(status);
        
    }
 

   
    
    private void setStatusMsg(String msg){
        status = msg;
    }

    @Override
    public String getStatusMsg(){
        return status;
    }
    
    @Override
    public void removeCar(String ref) {
        Info in = new Info();
        try{
       
        
        Query q = em.createNamedQuery("Info.findByRef");
     q.setParameter("ref", ref);
    
     in = (Info) q.getSingleResult();
     
     em.remove(in);
     this.status = "Operation Successful";
     this.setStatusMsg(status);
     
        }catch(NoResultException e){
      this.status = "This Car doesn't exist";
     this.setStatusMsg(status); 
     System.out.println(e.getMessage());
        }
     
    }

    @Override
    public void updateCarinfo(Info info, String filePath, String price, String ref) {
        
        Query qq = em.createNamedQuery("Info.findByRef");
        qq.setParameter("ref", ref);
        
        info = (Info) qq.getSingleResult();
        info.setPrice(Float.parseFloat(price));
        info.setImage(filePath);
        
        em.merge(info);
        em.flush();
        status = "Update Operation Successful";
        setStatusMsg(status);
    }

    @Override
    public List<Info> carStatus() {
return em.createQuery("From Info").getResultList();
    }

    @Override
    public void search(String ref) {
        Info inf;
        
     Query q = em.createNamedQuery("Info.findByRef");
     q.setParameter("ref", ref);
    
     inf = (Info) q.getSingleResult();
     
     setCaName(inf.getCarname());
     setCaModel(inf.getCarmodel());
     setCaPrice(inf.getPrice());
     setCaCategory(inf.getCategory());
     setCaYear(inf.getYear());
     setCaImg(inf.getImage());
     
    }
    
    public void setCaName (String n){
        this.carName = n;
    }
    
    public void setCaModel (String m){
        this.carModel = m;
    }
    public void setCaPrice (float p){
        this.carPrice = p;
    }
    public void setCaCategory (String c){
        this.carCategory = c;
    }
    public void setCaYear (String y){
        this.carYear = y;
    }
    public void setCaImg (String i){
        this.carImage = i;
    }

    @Override
    public String getCarName() {
        return this.carName;
    }

    @Override
    public String getCarModel() {
        return this.carModel;
    }

    @Override
    public String getCategory() {
        return this.carCategory;
    }

    @Override
    public String getFilepath() {
        return this.carImage;
    }

    @Override
    public String getManu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getCarPrice() {
        return this.carPrice;
    }

    @Override
    public String getCarYear() {
        return this.carYear;
    }

   
    
}
