
package mum.edu.model;

import java.io.Serializable;

/**
 * 
 * @param <IdentifierType>
 *        
 * @author Kimtey
 */
public interface Entity<IdentifierType extends Serializable> extends Serializable {

    IdentifierType getId();

    int getEntityVersion();

}
