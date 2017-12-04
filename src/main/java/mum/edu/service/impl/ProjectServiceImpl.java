/*
 * Created on Dec 2, 2017
 */
package mum.edu.service.impl;

import java.util.List;

import mum.edu.constant.TaskStatus;
import mum.edu.dao.DataAccessObject;
import mum.edu.dao.impl.ProjectDaoImpl;
import mum.edu.model.Project;
import mum.edu.service.AbstractEntityService;
import mum.edu.service.ProjectService;

public class ProjectServiceImpl extends AbstractEntityService<Project, Long> implements ProjectService{

    @Override
    //if we use sping it will be injected by spring
    protected DataAccessObject<Project, Long> getEntityDao() {
        return new ProjectDaoImpl();
    }

    public List<Project> getProjectByStatus(TaskStatus status) {
        return ((ProjectDaoImpl)getEntityDao()).getProjectByStatus(status);
    }

}
