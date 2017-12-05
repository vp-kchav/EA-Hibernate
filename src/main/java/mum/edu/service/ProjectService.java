/*
 * Created on Dec 2, 2017
 */
package mum.edu.service;

import java.util.List;

import mum.edu.constant.ResourceType;
import mum.edu.constant.TaskStatus;
import mum.edu.model.Project;

public interface ProjectService extends EntityService<Project, Long>{
    
    List<Project> getProjectByStatus(TaskStatus status);
    
    List<Project> findProjectBykeyWordAndLocation(String keyWord,String location);

    List<Project> findProjectByResourceType(ResourceType type);
    
    List<Project> findProjectOfferedByVolunteer();
}
