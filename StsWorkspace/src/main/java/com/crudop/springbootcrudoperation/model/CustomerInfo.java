package com.crudop.springbootcrudoperation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Table;

@Entity
@Table(name = "CustomerInfo")
public class CustomerInfo {

    private long id; 
    
    private String CustomerName;
    private String CustomerLocation;
    private long ContactNumber;
    private String PurchasedItem;
    private String DeliveryAddress;
 
    public CustomerInfo() {
  
    }
 
    public CustomerInfo(String CustomerName, String CustomerLocation, long ContactNumber,String PurchasedItem,String DeliveryAddress) {
         this.CustomerName = CustomerName;
         this.CustomerLocation = CustomerLocation;
         this.ContactNumber = ContactNumber;
         this.PurchasedItem = PurchasedItem;
         this.DeliveryAddress = DeliveryAddress;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "CustomerName", nullable = false )
    public String getCustomerName() {
        return CustomerName;
    }
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    
 
    @Column(name = "CustomerLocation", nullable = false)
    public String getCustomerLocation() {
        return CustomerLocation;
    }
    public void setCustomerLocation(String CustomerLocation) {
        this.CustomerLocation = CustomerLocation;
    }
 
    @Column(name = "ContactNumber", nullable = false)
    public long getContactNumber() {
        return ContactNumber;
    }
    public void setContactNumber(long ContactNumber) {
        this.ContactNumber = ContactNumber;
    }
    
    @Column(name = "PurchasedItem", nullable = false)
    public String getPurchasedItem() {
        return PurchasedItem;
    }
    public void setPurchasedItem(String PurchasedItem) {
        this.PurchasedItem = PurchasedItem;
    }
    
    @Column(name = "DeliveryAddress", nullable = false)
    public String getDeliveryAddress() {
        return DeliveryAddress;
    }
    public void setDeliveryAddress(String DeliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    }

    @Override
    public String toString() {
        return "customerinfo [ CustomerName=" + CustomerName + ", CustomerLocation=" + CustomerLocation + ", ContactNumber=" + ContactNumber
       + ", PurchasedItem=" + PurchasedItem +", DeliveryAddress=" + DeliveryAddress +"]";
    }
 
}
