/**
 * 
 */
package aegis.shield.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 2:30:41 - 21/05/2023
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "aegis.shield.aspect")
public class AOPConfig {

}
