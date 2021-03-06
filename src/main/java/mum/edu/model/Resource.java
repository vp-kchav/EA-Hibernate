/*
 * Created on Dec 2, 2017
 */
package mum.edu.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import mum.edu.constant.ResourceType;

@Entity
public class Resource extends AbstractLongEntity {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private ResourceType resourceType;
    
    private int numberOfResource;
    
    public Resource() {
        
    }
    
    public Resource(ResourceType resourceType, int numberOfResource) {
        super();
        this.resourceType = resourceType;
        this.numberOfResource = numberOfResource;
    }

    @Enumerated(EnumType.STRING)
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
