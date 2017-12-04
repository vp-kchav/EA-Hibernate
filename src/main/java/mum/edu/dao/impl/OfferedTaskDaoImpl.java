/*
 * Created on Dec 2, 2017
 */
package mum.edu.dao.impl;

import mum.edu.dao.AbstractHibernateDao;
import mum.edu.model.OfferedTask;

public class OfferedTaskDaoImpl extends AbstractHibernateDao<OfferedTask,Long> {

    @Override
    protected Class<? extends OfferedTask> getDomainClass() {
        return OfferedTask.class;
    }


   
}
