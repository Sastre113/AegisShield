/**
 * 
 */
package aegis.shield.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aegis.shield.model.entity.Usertb;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:47:37 - 30/04/2023
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<Usertb, String> {

}
