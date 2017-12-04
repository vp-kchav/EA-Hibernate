/*
 * Created on Dec 2, 2017
 */
package mum.edu.service.impl;

import mum.edu.dao.DataAccessObject;
import mum.edu.dao.impl.OfferedTaskDaoImpl;
import mum.edu.model.OfferedTask;
import mum.edu.service.AbstractEntityService;
import mum.edu.service.OfferedTaskService;

public class OfferedTaskServiceImpl extends AbstractEntityService<OfferedTask, Long> implements OfferedTaskService{

    @Override
    protected DataAccessObject<OfferedTask, Long> getEntityDao() {
        return new OfferedTaskDaoImpl();
    }

}
