package wedding.com.prasann;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("wedding.com")
@EntityScan("wedding.com.model")
@EnableJpaRepositories("wedding.com.jpa")
public class PrasannApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrasannApplication.class, args);
	}

}

//spring.datasource.url=jdbc:mysql://localhost:3306/prasann
//		spring.datasource.username=root
//		spring.datasource.password=Ritik123@
//		spring.datasource.platform=mysql
//		spring.jpa.hibernate.ddl-auto=update
//		spring.jpa.show-sql=true
