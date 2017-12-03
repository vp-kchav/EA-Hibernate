/*
 * Created on Dec 2, 2017
 */
package mum.edu.dao.impl;

import mum.edu.dao.AbstractHibernateDao;
import mum.edu.model.Task;

public class TaskDaoImpl extends AbstractHibernateDao<Task,Long> {

    @Override
    protected Class<? extends Task> getDomainClass() {
        return Task.class;
    }


   
}
