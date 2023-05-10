/**
 * 
 */
package aegis.shield.event.historical;

import org.springframework.context.ApplicationEvent;

import aegis.shield.model.dto.historical.IHistoricable;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:42:59 - 10/05/2023
 *
 */
public class HistoricalRecordEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private IHistoricable historicalRecord;
	
	public HistoricalRecordEvent(Object source, IHistoricable historicalRecord) {
		super(source);
		this.historicalRecord = historicalRecord;
	}

	public IHistoricable getHistoricalRecord() {
		return historicalRecord;
	}
}
