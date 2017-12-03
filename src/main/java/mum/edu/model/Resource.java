/*
 * Created on Dec 2, 2017
 */
package mum.edu.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import mum.edu.constant.ResourceType;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
    
    private int numberOfResource;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public ResourceType getResourceType() {
        return resourceType;
    }

    
    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    
    public int getNumberOfResource() {
        return numberOfResource;
    }

    
    public void setNumberOfResource(int numberOfResource) {
        this.numberOfResource = numberOfResource;
    }
}
