/**
 * 
 */
package aegis.shield.event.historical;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import aegis.shield.model.dto.historical.HistoricalRecordDTO;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 0:09:04 - 11/05/2023
 *
 */
@Component
public class HistoricalRecordEventPublisher {
	
	private final ApplicationEventPublisher eventPublisher;
	private final ScheduledExecutorService executorService;

	public HistoricalRecordEventPublisher(ApplicationEventPublisher eventPublisher) {
		super();
		this.eventPublisher = eventPublisher;
		this.executorService = Executors.newSingleThreadScheduledExecutor();
	}

	public <T> void postEvent(String tableName, String actionExecuted, T prevRecord) {
		HistoricalRecordDTO<?> historicalRecord = new HistoricalRecordDTO<>(tableName, actionExecuted, prevRecord);
		HistoricalRecordEvent event = new HistoricalRecordEvent(this, historicalRecord);
		
		// Con esto evitamos que el evento se procese inmediatamente
		executorService.schedule(() -> eventPublisher.publishEvent(event), 60000, TimeUnit.MILLISECONDS);
	}
}
