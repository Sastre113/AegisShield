/**
 * 
 */
package aegis.shield.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 0:16:20 - 11/05/2023
 *
 */
@Entity
@Table(name = "HISTORICALTB")
public class Historicaltb implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_RECORD", length = 36)
	private String idRecord;
	@Column(name = "TABLE_NAME", length = 200)
	private String tableName;
	@Column(name = "ACTION_EXECUTED", length = 200)
	private String actionExecuted;
	@Column(name = "PREV_RECORD", length = 4000)
	private String prevRecord;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateRecord;
	

	public String getIdRecord() {
		return idRecord;
	}

	public void setIdRecord(String idRecord) {
		this.idRecord = idRecord;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getActionExecuted() {
		return actionExecuted;
	}

	public void setActionExecuted(String actionExecuted) {
		this.actionExecuted = actionExecuted;
	}

	public String getPrevRecord() {
		return prevRecord;
	}

	public void setPrevRecord(String prevRecord) {
		this.prevRecord = prevRecord;
	}

	public LocalDateTime getDateRecord() {
		return dateRecord;
	}

	public void setDateRecord(LocalDateTime dateRecord) {
		this.dateRecord = dateRecord;
	}	
}
