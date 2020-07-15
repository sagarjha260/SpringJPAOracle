package SpringJPAORACLE.Config;

import javax.sql.DataSource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

 
@Configuration
@PropertySource("classpath:application.properties") 
public class ApplicationContextConfig 
{
    @Autowired
    private Environment env;
 
    @Bean(name = "dataSource")
    public DataSource getDataSource() 	
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
         
        return dataSource;
    }
    
    
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
       LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
       em.setDataSource(getDataSource());
       em.setPackagesToScan(new String[] { "SpringJPAORACLE.Model" });
  
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       em.setJpaVendorAdapter(vendorAdapter);
  
       return em;
    }
    
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
     
        return transactionManager;
    }
    
    @Bean
	RestTemplate restTemplate() {
    	 return new RestTemplate();
	}
 
}
