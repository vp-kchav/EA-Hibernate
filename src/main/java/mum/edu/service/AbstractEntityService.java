/*
 * Created on 15 sept. 2008
 */
package mum.edu.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import mum.edu.dao.DataAccessObject;

/**
 * 
 * @author kimtey
 * 
 */
public abstract class AbstractEntityService<EntityType extends Serializable, IdentifierType extends Serializable> implements EntityService<EntityType, IdentifierType> {


    /**
     * {@inheritDoc}
     */
    public void delete(final EntityType entity) throws RuntimeException {
        System.out.println(" delete entity : " + entity.toString());
        try {
            getEntityDao().delete(entity);
        }
        catch (RuntimeException dive) {
            throw new RuntimeException(dive);
        }
    }


    /**
     * {@inheritDoc}
     */
    public boolean exists(final IdentifierType id) {
        return getEntityDao().exists(id);
    }

    /**
     * {@inheritDoc}
     */
    public void deleteById(final IdentifierType entityId) throws RuntimeException, EntityNotFoundException {
        System.out.println(" delete entity : " + entityId);
        EntityType entity = getById(entityId);
        delete(entity);
    }


    /**
     * {@inheritDoc}
     */
    public void evict(final EntityType entity) {
        getEntityDao().evict(entity);
    }

    /**
     * {@inheritDoc}
     */
    public EntityType getById(final IdentifierType entityId) {
        System.out.println(" get entity : " + entityId);
        EntityType entity = getEntityDao().get(entityId);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public EntityType save(final EntityType entity) throws RuntimeException {
        System.out.println(" save entity : " + entity.toString());

        // sauvegarde de l'entité
        IdentifierType cle = getEntityDao().save(entity);

        // recharge de l'entité sauvegardée
        EntityType entityPersistee = getEntityDao().get(cle);

        return entityPersistee;
    }


    /**
     * {@inheritDoc}
     */
    public EntityType update(final EntityType entity) throws RuntimeException {

        System.out.println(" update entity : " + entity.toString());

        getEntityDao().update(entity);

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public EntityType merge(final EntityType entity) {
        System.out.println(" merge entity : " + entity.toString());
        EntityType merged = getEntityDao().merge(entity);
        return merged;
    }

    /**
     * {@inheritDoc}
     */
    public List<EntityType> findAll() {
        List<EntityType> entities = getEntityDao().findAll();
        return entities;
    }

    /**
     * @return the entityDao
     */
    protected abstract DataAccessObject<EntityType, IdentifierType> getEntityDao();

}
