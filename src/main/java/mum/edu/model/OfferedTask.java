/*
 * Created on Dec 3, 2017
 */
package mum.edu.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mum.edu.constant.ResourceType;

@Entity
public class OfferedTask extends AbstractLongEntity {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Date offeredDate;
       
    private ResourceType offered;
    
    private Task task;

    public OfferedTask() {
        
    }
    
    public OfferedTask(Date offeredDate, ResourceType offered) {
        super();
        this.offeredDate = offeredDate;
        this.offered = offered;
    }


    @Temporal(TemporalType.DATE)
    public Date getOfferedDate() {
        return offeredDate;
    }

    
    public void setOfferedDate(Date offeredDate) {
        this.offeredDate = offeredDate;
    }

    @Enumerated(EnumType.STRING)
    public ResourceType getOffered() {
        return offered;
    }

    
    public void setOffered(ResourceType offered) {
        this.offered = offered;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="task_id")
    public Task getTask() {
        return task;
    }

    
    public void setTask(Task task) {
        this.task = task;
    }
}
