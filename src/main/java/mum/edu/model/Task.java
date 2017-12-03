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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mum.edu.constant.TaskStatus;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    
    @OneToOne
    @JoinColumn(name="resource_id")
    private Resource resource;
    
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
    
    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }



    
    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }



    public Long getId() {
        return id;
    }


    
    public void setId(Long id) {
        this.id = id;
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


    
    public TaskStatus getStatus() {
        return status;
    }


    
    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    
    public Resource getResource() {
        return resource;
    }


    
    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
