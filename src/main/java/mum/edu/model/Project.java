/*
 * Created on Dec 2, 2017
 */
package mum.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project extends AbstractLongEntity {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String description;
    
    private String Location;
    
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    private List<Task> tasks = new ArrayList<Task>();

    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getLocation() {
        return Location;
    }

    
    public void setLocation(String location) {
        Location = location;
    }

    
    public Date getStartDate() {
        return startDate;
    }

    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
    public Date getEndDate() {
        return endDate;
    }

    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    public List<Task> getTasks() {
        return tasks;
    }

    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}


