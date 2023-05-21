/**
 * 
 */
package aegis.shield.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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

		Object objetoModificado = joinPoint.getArgs()[0];

		System.out.println("Hola");

		Historicaltb historicalEntity = HistoricalMapper.INSTANCE.toCreate(null);
		this.historicalRepository.save(historicalEntity);
	}

}
