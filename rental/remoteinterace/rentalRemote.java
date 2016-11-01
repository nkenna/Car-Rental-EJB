/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rental.remoteinterace;

import com.rental.entity.Info;
import java.util.List;
import java.util.Random;
import javax.ejb.Remote;
import javax.persistence.EntityManager;

/**
 *
 * @author STEINACOZ-PC
 */
@Remote
public interface rentalRemote{
    
    
    
    //Admin business methods
    void addNewCar(String carName, String model, String available, String category, String FilePath, String manu, String price, String year);
    void removeCar (String catalogueNumber);
    void updateCarinfo (Info info, String filePath, String price, String ref);
    List<Info> carStatus();
    
    
    String getStatusMsg();
    String getCarName();
    String getCarModel();
    String getCategory();
    String getFilepath();
    String getManu();
    float getCarPrice();
    String getCarYear();
    
    
    
    void search(String ref);
    
}
