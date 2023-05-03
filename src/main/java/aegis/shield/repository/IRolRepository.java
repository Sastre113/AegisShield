/**
 * 
 */
package aegis.shield.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aegis.shield.model.entity.Roltb;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 22:07:56 - 03/05/2023
 *
 */
public interface IRolRepository extends JpaRepository<Roltb, String> {

}
