/*
 * Created on Dec 2, 2017
 */
package mum.edu.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import mum.edu.constant.ResourceType;
import mum.edu.constant.TaskStatus;
import mum.edu.model.Address;
import mum.edu.model.Beneficiary;
import mum.edu.model.OfferedTask;
import mum.edu.model.Project;
import mum.edu.model.Resource;
import mum.edu.model.Task;
import mum.edu.service.ProjectService;
import mum.edu.service.impl.ProjectServiceImpl;

public class ProjectServiceTest {
    
    private ProjectService service = new ProjectServiceImpl();
    
    @Test
    @Ignore
    public void testGet() {
        Project p = service.getById(1222l);
        System.out.println("sdfdfdf");
    }
    
    @Test
//    @Ignore
    public void testInsert() {
        Project p = new Project();
        List<Task> tasks = new ArrayList<Task>();
        //Resource
        Resource r = new Resource();
        r.setNumberOfResource(3);
        r.setResourceType(ResourceType.ASSET);
        //Beneficary
        List<Beneficiary> bes = new ArrayList<Beneficiary>();
        Beneficiary be = new Beneficiary();
        be.setFirstName("Kimtey");
        be.setLastName("Chav");
        Address address = new Address();
        address.setCity("Fairfield");
        address.setState("IA");
        address.setStreet("4th street");
        address.setZipCode("52557");
        be.setAddress(address);
        bes.add(be);
        //offer task
        OfferedTask ot = new OfferedTask();
        ot.setOffered(ResourceType.VOLUNTEER);
        ot.setOfferedDate(new Date());
        //task
        Task task = new Task();
        task.setEndDate(new Date());
        task.setStartDate(new Date());
        task.setStatus(TaskStatus.WAITING);
        task.setResource(r);
        task.setBeneficiaries(bes);
        task.addOfferedTask(ot);
        tasks.add(task);
        
        //project
        p.setDescription("test description");
        p.setEndDate(new Date());
        p.setStartDate(new Date());
        p.setLocation("Phnom Penh");
        p.setTasks(tasks);
        Project pro = service.save(p);
        
        System.out.println(pro.getId());
    }

}
