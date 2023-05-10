/**
 * 
 */
package aegis.shield.service.historical;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import aegis.shield.event.historical.HistoricalRecordEvent;
import aegis.shield.mapper.HistoricalMapper;
import aegis.shield.model.dto.historical.IHistoricable;
import aegis.shield.model.entity.Historicaltb;
import aegis.shield.repository.IHistoricalRepository;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 0:13:53 - 11/05/2023
 *
 */
@Service
public class HistoricalRecordService {

	private IHistoricalRepository historicalRepository;
	
	public HistoricalRecordService(IHistoricalRepository historicalRepository) {
		this.historicalRepository = historicalRepository;
	}

	@Async
	@EventListener
	public void handleHistoricalRecordEvent(HistoricalRecordEvent event) {
		IHistoricable historicalRecord = event.getHistoricalRecord();
		Historicaltb historicalEntity = HistoricalMapper.INSTANCE.toCreate(historicalRecord);
		this.historicalRepository.save(historicalEntity);
	}
}
