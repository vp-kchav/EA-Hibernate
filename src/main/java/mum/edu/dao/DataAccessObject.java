/*
 * Created on 20 août 08
 */
package mum.edu.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
     * Renvoit vrai si l'entité d'id id existe, faux sinon.
     * 
     * @param id
     *            : id de l'entité
     * @return : boolean
     */
    boolean exists(IdentifierType id);

    /**
     * 
     * @param entity
     */
    void refresh(EntityType entity);

    /**
     * Renvoit la liste des entités dont les identifiants sont contenus dans ids.
     * 
     * @param ids
     *            : identifiants des entités.
     * @return {@link List}.
     */
    List<EntityType> findByIds(IdentifierType[] ids);

    /**
     * Méthode de chargement d'une entité, <b>Effectue une requête sql</b>.<br>
     * Cette méthode retourne <b>l'entité persistée</b>
     * 
     * @param id
     *            ID de l'entité.
     * @return Entité de la source de donnée.
     */
    EntityType get(IdentifierType id);

    /**
     * Met à jour l'instance persistante donnée.
     * 
     * @param t
     *            Instance persistente.
     */
    void update(EntityType t);

    /**
     * Persiste l'instance transient donnée.
     * 
     * @param t
     *            Instance transient.
     * @return Identifant généré.
     */
    IdentifierType save(EntityType t);

    /**
     * Persiste l'instance transient donnée ou met à jour l'instance persistante.
     * 
     * @param t
     *            Instance transient ou persistante.
     */
    void saveOrUpdate(EntityType t);

    /**
     * Supprime l'instance persistente donnée.
     * 
     * @param t
     *            Instance persistente.
     */
    void delete(EntityType t);

    /**
     * Supprime l'instance persistente donnée.
     * 
     * @param id
     *            ID de l'instance persistente.
     */
    void deleteById(IdentifierType id);

    /**
     * Retourne une entité persistante mise à jour à partir de t.
     * 
     * @param t
     *            : EntityType
     * @return EntityType
     */
    EntityType merge(EntityType t);

    /**
     * Exécute une recherche nommée
     * 
     * @param queryName
     *            : {@link String} nom de la requète,
     * @param parameters
     *            : map nom paramètres/valeurs
     * @return {@link List}
     */
    List<EntityType> findByNamedQuery(String queryName, Map<String, Object> parameters);

    /**
     * Exécute une recherche nommée
     * 
     * @param queryName
     *            : {@link String} nom de la requète,
     * @return {@link List}
     */
    List<EntityType> findByNamedQuery(String queryName);

    /**
     * Renvoit toutes les entités
     * 
     * @return {@link List}
     */
    List<EntityType> findAll();

    /**
     * Renvoit toutes les entités
     * 
     * @param firstResult
     *            : indice du premier élément renvoyé.
     * @param maxResults
     *            : nombre de résultats renvoyés.
     * @return {@link List}
     */
    List<EntityType> findAll(int firstResult, int maxResults);

    /**
     * Renvoit une liste paginée d'entités dont les id sont contenus dans entitiesId. La pagination est réalisée de façon transparente, nécessite qu'une session hibernate soit active pendant
     * l'itération de la liste.
     * 
     * @param entitiesId
     *            :
     * @return : {@link List}
     */
    List<EntityType> getPaginatedList(IdentifierType[] entitiesId);

    /**
     * Renvoit une liste paginée d'entités dont les id sont contenus dans entitiesId. La pagination est réalisée de façon transparente, nécessite qu'une session hibernate soit active pendant
     * l'itération de la liste.
     * 
     * @param entitiesId
     *            ID d'entité.
     * @param pageSize
     *            Taille de la page.
     * @return {@link List}
     */
    List<EntityType> getPaginatedList(IdentifierType[] entitiesId, int pageSize);

    /**
     * Evicte une entitée du cache.
     * 
     * @param entity
     *            EntityType
     * 
     */
    void evict(final EntityType entity);

    /**
     * Vide la session.
     */
    void clearSession();

}
