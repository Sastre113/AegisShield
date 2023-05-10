/**
 * 
 */
package aegis.shield.model.dto.historical;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:56:13 - 10/05/2023
 *
 */
public interface IHistoricable {

	public String getTableName();
	public String getActionExecuted();
	public Object getPrevRecord();
	public String prevRecordToJson();

}
