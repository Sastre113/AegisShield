/**
 * 
 */
package aegis.shield.model.dto.historical;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:54:12 - 10/05/2023
 *
 */
public class HistoricalRecordDTO<T> implements IHistoricable {

	private String tableName;
	private String actionExecuted;
	private T prevRecord;

	public HistoricalRecordDTO(String tableName, String actionExecuted, T prevRecord) {
		super();
		this.tableName = tableName;
		this.actionExecuted = actionExecuted;
		this.prevRecord = prevRecord;
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

	@Override
	public String prevRecordToJson() {
		try {
			return new ObjectMapper().writeValueAsString(this.getPrevRecord());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
    }
}
