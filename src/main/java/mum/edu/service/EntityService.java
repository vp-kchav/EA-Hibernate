
package mum.edu.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

/**
 * @author Kimtey
 * 
 */
public interface EntityService<EntityType extends Serializable, IdentifierType extends Serializable> {


    /**
     * 
     * @param entity
     */
    void evict(EntityType entity);

    /**
     * Renvoit vrai si une entité d'id id existe
     * 
     * @param id
     * @return : boolean
     */
    boolean exists(IdentifierType id);

    /**
     * Renvoit l'entité d'identifiant entityId. <br>
     * retourne null si l'entité n'a pas été trouvée.
     * 
     * @param entityId
     *            : identifiant de l'entité.
     * @return l'entité d'identifiant entityId.
     */
    EntityType getById(IdentifierType entityId);

    /**
     * 
     * @param entity
     * @return
     * @throws RuntimeException
     */
    EntityType save(EntityType entity) throws RuntimeException;

    /**
     * 
     * @param entity
     * @return
     * @throws RuntimeException
     */
    EntityType update(EntityType entity) throws RuntimeException;

    /**
     * 
     * @param entity
     * @throws RuntimeException
     */
    void delete(EntityType entity) throws RuntimeException;

    /**
     * 
     * @param entityId
     * @throws RuntimeException
     * @throws EntityNotFoundException
     */
    void deleteById(IdentifierType entityId) throws RuntimeException, EntityNotFoundException;

    /**
     * 
     * @param entity
     * @return
     */
    EntityType merge(EntityType entity);

    /**
     * 
     * @return
     */
    List<EntityType> findAll();

}
