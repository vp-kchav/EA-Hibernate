/*
 * Created on Dec 2, 2017
 */
package mum.edu.service.impl;

import mum.edu.dao.DataAccessObject;
import mum.edu.dao.impl.TaskDaoImpl;
import mum.edu.model.Task;
import mum.edu.service.AbstractEntityService;
import mum.edu.service.TaskService;

public class TaskServiceImpl extends AbstractEntityService<Task, Long> implements TaskService{

    @Override
    //if we use sping it will be injected by spring
    protected DataAccessObject<Task, Long> getEntityDao() {
        return new TaskDaoImpl();
    }

}
