package SpringJPAORACLE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import SpringJPAORACLE.Model.Laptop;
import SpringJPAORACLE.Model.Student;

@SpringBootApplication
 /* @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
 * @ComponentScan({"SpringJPAORACLE.*"})
 * @EnableJpaRepositories({"SpringJPAORACLE.Repo"})
 * @EntityScan({"SpringJPAORACLE.*"})
 */
public class SpringJpaoracleApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringJpaoracleApplication.class, args);
		
		
	}

}
