/*
 * Created on Dec 2, 2017
 */
package mum.edu.dao.impl;

import mum.edu.dao.AbstractHibernateDao;
import mum.edu.model.Project;

public class ProjectDaoImpl extends AbstractHibernateDao<Project,Long> {

    @Override
    protected Class<? extends Project> getDomainClass() {
        return Project.class;
    }


   
}
