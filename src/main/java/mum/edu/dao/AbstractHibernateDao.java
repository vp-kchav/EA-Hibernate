package mum.edu.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

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
        EntityType entity = getDomainClass().cast(getSession().get(getDomainClass(), id));
        if (entity == null) {
            throw new ObjectNotFoundException(id,getDomainClass().toString());
        }
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(final IdentifierType id) {
        try {
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
        getSession().update(t);
    }

    /**
     * {@inheritDoc}
     */

    public IdentifierType save(final EntityType t) {
        return getKeyClass().cast(getSession().save(t));
    }

    /**
     * {@inheritDoc}
     */

    public void saveOrUpdate(final EntityType t) {
        getSession().saveOrUpdate(t);
    }

    /**
     * {@inheritDoc}
     */
    public void delete(final EntityType t) {
        getSession().delete(t);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteById(final IdentifierType id) {
        EntityType t = load(id);
        delete(t);
    }
    
    /**
     * {@inheritDoc}
     */
    public EntityType load(final IdentifierType id) {
        return getDomainClass().cast(getSession().load(getDomainClass(), id));
    }

    /**
     * {@inheritDoc}
     */
    public void refresh(final EntityType entity) {
        getSession().refresh(entity);
    }

    /**
     * {@inheritDoc}
     */
    public EntityType merge(final EntityType t) {
        return getDomainClass().cast(getSession().merge(t));
    }


    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<EntityType> findAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(getDomainClass());
        return criteria.list();
    }
    
    /**
     * {@inheritDoc}
     */
    public void evict(final EntityType entity) {
        getSession().evict(entity);
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
