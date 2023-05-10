/**
 * 
 */
package aegis.shield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aegis.shield.model.entity.Historicaltb;
import aegis.shield.repository.IHistoricalRepository;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 1:06:21 - 11/05/2023
 *
 */
@RestController
@RequestMapping("/historical")
@PreAuthorize("hasAnyRole('ADMIN')")
public class HistoricalController {

	@Autowired
	private IHistoricalRepository historicalRepository;
	
	@GetMapping(value = "")
	public List<Historicaltb> getAllHistorical() {
		return this.historicalRepository.findAll();
	}
	
}
