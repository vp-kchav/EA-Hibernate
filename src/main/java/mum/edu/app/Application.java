package mum.edu.app;

import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;

import mum.edu.constant.ResourceType;
import mum.edu.constant.TaskStatus;
import mum.edu.model.Beneficiary;
import mum.edu.model.OfferedTask;
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
	
	public static void offeredTask() {
	    System.out.println("Please input task ID you want to offered:");
	    Long taskId = MenuBuilder.inputLong();
	    Task task  = taskService.getById(taskId);
	    OfferedTask ot = new OfferedTask(new Date(),ResourceType.VOLUNTEER);
	    task.addOfferedTask(ot);
	    taskService.merge(task);
	    System.out.println("Offered a task has been sent!!!");
	}
	
	@SuppressWarnings("unchecked")
	public static void getTasksByProject() {
	    System.out.println("-------Tasks---------");
	    System.out.println("Please input project ID:");
	    Long pId = MenuBuilder.inputLong();
        Project project = projectServise.getById(pId);
        for(Task task : project.getTasks()) {
            System.out.println(task.getStatus());
            System.out.println(task.getStartDate());
            System.out.println(task.getEndDate());
            System.out.println(task.getResource().getResourceType().toString());
            System.out.println(task.getResource().getNumberOfResource());
        }
	    System.out.println("----------------");
	}
	
	public static void getProjectBystatus() {
	    System.out.println("please input the status of Project : 1-WAITING , 2-CODING , 3-VALIDATE , 4-CODE_REVIEW , 5-DONE");
	    int statusInt = MenuBuilder.inputInt();
	    TaskStatus status=null;
	    switch(statusInt) {
	        case 1:
	           status = TaskStatus.WAITING;
	           break;
	        case 2:
	            status = TaskStatus.CODING;
	            break;
	        case 3:
	            status = TaskStatus.VALIDATE;
	            break;
	        case 4:
	            status = TaskStatus.CODE_REVIEW;
	            break;
	        case 5:
	            status = TaskStatus.DONE;
	            break;       
	    }
	    List<Project> projects = projectServise.getProjectByStatus(status);
	    if(projects != null) {
	        for(Project project : projects) {
	            System.out.println(project.getDescription());
	        }
	    }
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
                  offeredTask();
                  break;
                  
              case 5:
                  getTasksByProject();
                  break;
                  
              case 6:
                  getProjectBystatus();
                  break;
              
              case 7:                  
                  break;
              
              case 8:
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
