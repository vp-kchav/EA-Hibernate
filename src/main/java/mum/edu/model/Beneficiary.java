/*
 * Created on Dec 2, 2017
 */
package mum.edu.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Beneficiary extends AbstractLongEntity{
   
    private String firstName;
    
    private String LastName;
    
    private String gender;
    
    @Embedded
    private Address address;
    
    public String getFirstName() {
        return firstName;
    }

    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getLastName() {
        return LastName;
    }

    
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    
    public String getGender() {
        return gender;
    }

    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public Address getAddress() {
        return address;
    }

    
    public void setAddress(Address address) {
        this.address = address;
    }
}
