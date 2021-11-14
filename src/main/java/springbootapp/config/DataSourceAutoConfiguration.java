package springbootapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
public class DataSourceAutoConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //dataSource.setUsername("root");
        //dataSource.setPassword("mysql");
        //dataSource.setUrl(
          //      "jdbc:mysql://172.18.0.2:3306/trainee?createDatabaseIfNotExist=true");

        return dataSource;
    }
}
