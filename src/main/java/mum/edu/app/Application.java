package mum.edu.app;

import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;

import mum.edu.constant.ResourceType;
import mum.edu.constant.TaskStatus;
import mum.edu.model.Beneficiary;
import mum.edu.model.Project;
import mum.edu.model.Resource;
import mum.edu.model.Task;
import mum.edu.service.ProjectService;
import mum.edu.service.TaskService;
import mum.edu.service.impl.ProjectServiceImpl;
import mum.edu.service.impl.TaskServiceImpl;


public class Application {

	private static SessionFactory session;
	private static ProjectService projectServise = new ProjectServiceImpl();
	private static TaskService taskService = new TaskServiceImpl();
	
	public static void addNewTask() {
	    System.out.println("Please input Id of Project");
	    Long pId = MenuBuilder.inputLong();
	    try {
	        Project p = projectServise.getById(pId);
	        Task task  = new Task();
	        Resource resource = new Resource();
	        resource.setResourceType(ResourceType.VOLUNTEER);
	        resource.setNumberOfResource(3);
	        task.setResource(resource);
	        task.setStatus(TaskStatus.WAITING);
	        task.setStartDate(new Date());
	        task.setEndDate(MenuBuilder.inputDate());
	        p.addTask(task);
	        projectServise.update(p);
	    }catch(ObjectNotFoundException onfe) {
	        System.out.println("please input valid project");
	    }
	}
	
	public static void displayProject() {
	    List<Project> projects = projectServise.findAll();
	    System.out.println("---------1) Display projects---------------");
	    for(Project p : projects) {
	        System.out.println(p.getDescription());
	        System.out.println(p.getLocation());
	        for(Task task : p.getTasks()) {
	            for(Beneficiary be : task.getBeneficiaries()) {
	                System.out.println(be.getFirstName() + " " + be.getLastName());
	                System.out.println(be.getAddress().toString());
	            }
	        }
	    }
	    System.out.println("------------------------");
	}

	public static void deleteTask() {
	    System.out.println("please input Task ID to delete:");
	    Long taskId = MenuBuilder.inputLong();
	    taskService.deleteById(taskId);
	    System.out.println("Delete Successfully!!!");
	}
	public static void main(String[] args) {
	    while(true){
          int choice = MenuBuilder.menu();
          switch (choice) {
              case 1:
                  displayProject();
                  break;
          
              case 2:
                  addNewTask();
                  break;
                  
              case 3:
                  deleteTask();
                  break;
                  
              case 4:
                  break;
                  
              case 5:
                  break;
                  
              case 6:
                  break;
                  
              case 9:
                  System.out.println("Good Bye");
                  System.exit(0);
                  break;
      
              default:
                  break;
          }
      }
	}


}
