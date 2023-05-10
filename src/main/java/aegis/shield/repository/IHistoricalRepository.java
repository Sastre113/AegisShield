/**
 * 
 */
package aegis.shield.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aegis.shield.model.entity.Historicaltb;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 0:15:51 - 11/05/2023
 *
 */
public interface IHistoricalRepository extends JpaRepository<Historicaltb, String> {

}
