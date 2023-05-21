/**
 * 
 */
package aegis.shield.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.historical.IHistoricable;
import aegis.shield.model.entity.Historicaltb;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 0:20:21 - 11/05/2023
 *
 */
@Mapper(componentModel = "spring")
public interface HistoricalMapper {

	public HistoricalMapper INSTANCE = Mappers.getMapper(HistoricalMapper.class);
	
	
	@Mapping(expression  = "java(java.util.UUID.randomUUID().toString())", target = "idRecord")
	@Mapping(source = "tableName", target = "tableName")
	@Mapping(source = "actionExecuted", target = "actionExecuted")
	@Mapping(expression  = "java(historicalRecord.prevRecordToJson())", target = "prevRecord")
	@Mapping(expression = "java(java.time.LocalDateTime.now())", target = "dateRecord")
	public Historicaltb toCreate(IHistoricable historicalRecord);
	
	
	@Mapping(expression  = "java(java.util.UUID.randomUUID().toString())", target = "idRecord")
	@Mapping(source = "tableName", target = "tableName")
	@Mapping(source = "actionExecuted", target = "actionExecuted")
	@Mapping(source  = "prevRecord", target = "prevRecord")
	@Mapping(expression = "java(java.time.LocalDateTime.now())", target = "dateRecord")
	public Historicaltb toCreate(String tableName, String actionExecuted, String prevRecord);
}
