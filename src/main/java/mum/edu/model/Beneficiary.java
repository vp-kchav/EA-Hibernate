/*
 * Created on Dec 2, 2017
 */
package mum.edu.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
   
    private String firstName;
    
    private String LastName;
    
    private String gender;
    
    @Embedded
    private Address address;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
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
