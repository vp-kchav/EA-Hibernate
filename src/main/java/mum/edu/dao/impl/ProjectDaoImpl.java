/*
 * Created on Dec 2, 2017
 */
package mum.edu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mum.edu.dao.AbstractHibernateDao;
import mum.edu.model.Project;

public class ProjectDaoImpl extends AbstractHibernateDao<Project,Long> {

    @Override
    protected Class<? extends Project> getDomainClass() {
        return Project.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> findAll() {
        Transaction tx = getSession().beginTransaction();
        Session session = getSession();
        Query query =  session.createQuery("SELECT p FROM Project p");
        return (List<Project>) query.list();
    }
   
}
