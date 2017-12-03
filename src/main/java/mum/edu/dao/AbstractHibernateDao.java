package mum.edu.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mum.edu.persistance.HibernateUtil;

/**
 * DAO abstrait utilisant la généricité.
 * 
 * @param <EntityType>
 *            Enitée du domaine.
 * @param <IdentifierType>
 *            Type de clé de l'entitée du domaine.
 * 
 * @author g.blottiere
 */
public abstract class AbstractHibernateDao<EntityType extends Serializable, IdentifierType extends Serializable> implements DataAccessObject<EntityType, IdentifierType> {

    protected static final int MAX_ELEMENTS_IN = 2000;
    protected static final int DEFAULT_PAGE_SIZE = 200;

    /**
     * Classe de la clé.
     */
    private Class<IdentifierType> _keyClass = getKeyClass();

    /**
     * @return Classe du domaine.
     */
    protected abstract Class<? extends EntityType> getDomainClass();

    /**
     * @return Classe du domaine.
     */
    @SuppressWarnings("unchecked")
    protected Class<IdentifierType> getKeyClass() {
        if (_keyClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            _keyClass = (Class<IdentifierType>) thisType.getActualTypeArguments()[1];
        }
        return _keyClass;
    }
    
    /**
     * {@inheritDoc}
     */
    public EntityType get(final IdentifierType id) {
        Transaction tx = getSession().beginTransaction();
        EntityType entity = getDomainClass().cast(getSession().get(getDomainClass(), id));
        if (entity == null) {
            throw new ObjectNotFoundException(id,getDomainClass().toString());
        }
        tx.commit();
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(final IdentifierType id) {
        try {
            Transaction tx = getSession().beginTransaction();
            EntityType entity = get(id);
            if (entity != null) {
                return true;
            }
            return false;
        }
        catch (ObjectNotFoundException orfe) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void update(final EntityType t) {
        Transaction tx = getSession().beginTransaction();
        getSession().update(t);
        tx.commit();
    }

    /**
     * {@inheritDoc}
     */

    public IdentifierType save(final EntityType t) {
        Transaction tx = getSession().beginTransaction();
        IdentifierType saved = getKeyClass().cast(getSession().save(t));
        tx.commit();
        return saved;
    }

    /**
     * {@inheritDoc}
     */

    public void saveOrUpdate(final EntityType t) {
        Transaction tx = getSession().beginTransaction();
        getSession().saveOrUpdate(t);
        tx.commit();
    }

    /**
     * {@inheritDoc}
     */
    public void delete(final EntityType t) {
        Transaction tx = getSession().beginTransaction();
        getSession().delete(t);
        tx.commit();
    }

    /**
     * {@inheritDoc}
     */
    public void deleteById(final IdentifierType id) {
        Transaction tx = getSession().beginTransaction();
        EntityType t = load(id);
        delete(t);
        tx.commit();
    }
    
    /**
     * {@inheritDoc}
     */
    public EntityType load(final IdentifierType id) {
        Transaction tx = getSession().beginTransaction();
        return getDomainClass().cast(getSession().load(getDomainClass(), id));
    }

    /**
     * {@inheritDoc}
     */
    public void refresh(final EntityType entity) {
        Transaction tx = getSession().beginTransaction();
        getSession().refresh(entity);
        tx.commit();
    }

    /**
     * {@inheritDoc}
     */
    public EntityType merge(final EntityType t) {
        Transaction tx = getSession().beginTransaction();
        EntityType updated = getDomainClass().cast(getSession().merge(t));
        tx.commit();
        return updated;
    }


    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<EntityType> findAll() {
        Transaction tx = getSession().beginTransaction();
        Session session = getSession();
        Criteria criteria = session.createCriteria(getDomainClass());
        List<EntityType> result = criteria.list();
        tx.commit();
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public void evict(final EntityType entity) {
        Transaction tx = getSession().beginTransaction();
        getSession().evict(entity);
        tx.commit();
    }

    /**
     * {@inheritDoc}
     */
    public void clearSession() {
        getSession().clear();
    }

    protected int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public Session getSession() {
        return HibernateUtil.getInstance().getSessionFactory().getCurrentSession();
    }
}
