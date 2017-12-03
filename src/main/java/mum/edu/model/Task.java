/*
 * Created on Dec 2, 2017
 */
package mum.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mum.edu.constant.TaskStatus;

@Entity
public class Task extends AbstractLongEntity{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    
    private TaskStatus status;
    
    
    private Resource resource;
    
    
    private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
    
    public Task() {
        
    }
    
    public Task(Date startDate, Date endDate, TaskStatus status, Resource resource, List<Beneficiary> beneficiaries) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.resource = resource;
        this.beneficiaries = beneficiaries;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
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


    @Enumerated(EnumType.STRING)
    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="resource_id")
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
