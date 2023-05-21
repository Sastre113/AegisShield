/**
 * 
 */
package aegis.shield.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import aegis.shield.mapper.HistoricalMapper;
import aegis.shield.model.entity.Historicaltb;
import aegis.shield.repository.IHistoricalRepository;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 1:20:11 - 21/05/2023
 *
 */
@Aspect
@Component
public class HistorialRecordAspect {

	private IHistoricalRepository historicalRepository;

	public HistorialRecordAspect(IHistoricalRepository historicalRepository) {
		super();
		this.historicalRepository = historicalRepository;
	}

	@AfterReturning(pointcut = "execution(public * aegis.shield.service.UserService.*(..))", returning = "result")
	public void addHistoricalRecord(JoinPoint joinPoint, Object result) {

		String accion = joinPoint.getSignature().getName();

		Historicaltb historicalEntity = HistoricalMapper.INSTANCE.toCreate("USERTB" ,accion , this.objectToString(result));
		this.historicalRepository.save(historicalEntity);
	}
	
	private <T> String objectToString(T object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
    }

}
