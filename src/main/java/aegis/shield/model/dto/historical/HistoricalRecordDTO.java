/**
 * 
 */
package aegis.shield.model.dto.historical;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:54:12 - 10/05/2023
 *
 */
public final class HistoricalRecordDTO<T> implements IHistoricable {

	private final String tableName;
	private final String actionExecuted;
	private final T prevRecord;
	private final LocalDateTime dateRecord;

	public HistoricalRecordDTO(String tableName, String actionExecuted, T prevRecord) {
		super();
		this.tableName = tableName;
		this.actionExecuted = actionExecuted;
		this.prevRecord = prevRecord;
		this.dateRecord = LocalDateTime.now();
	}

	public String getTableName() {
		return tableName;
	}

	public String getActionExecuted() {
		return actionExecuted;
	}

	public T getPrevRecord() {
		return prevRecord;
	}

	public LocalDateTime getDateRecord() {
		return dateRecord;
	}

	@Override
	public String prevRecordToJson() {
		try {
			return new ObjectMapper().writeValueAsString(this.prevRecord);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
    }
}
