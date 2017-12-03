/*
 * Created on 20 août 08
 */
package mum.edu.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author s.abbad
 * 
 * @param <EntityType>
 *            Enitée du domaine.
 * @param <IdentifierType>
 *            Type de clé de l'entitée du domaine.
 */
public interface DataAccessObject<EntityType extends Serializable, IdentifierType extends Serializable> {

    String ID_ENTITY_FIELD = "id";

    /**
     * 
     * @param id
     * @return : boolean
     */
    boolean exists(IdentifierType id);

    /**
     * 
     * @param entity
     */
    void refresh(EntityType entity);

    /**
     * 
     * @param id
     */
    EntityType get(IdentifierType id);

    /**
     * 
     * @param t
     *            Instance persistente.
     */
    void update(EntityType t);

    /**
     * 
     * @param t
     *            Instance transient.
     * @return Identifant .
     */
    IdentifierType save(EntityType t);

    /**
     * 
     * @param t
     */
    void saveOrUpdate(EntityType t);

    /**
     * 
     * @param t
     */
    void delete(EntityType t);

    /**
     * 
     * @param id
     */
    void deleteById(IdentifierType id);

    /**
     * 
     * @param t : EntityType
     * @return EntityType
     */
    EntityType merge(EntityType t);

    /**
     * 
     * @return {@link List}
     */
    List<EntityType> findAll();
   
    /**
     * 
     * @param entity
     *            EntityType
     * 
     */
    void evict(final EntityType entity);

    /**
     * 
     * 
     */
    void clearSession();

}
