package springbootapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
public class DataSourceAutoConfiguration {

    @Value("${dbUser}")
    private String dbUser;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(dbUser);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbUser);
        dataSource.setUrl(dbUser);

        return dataSource;
    }
}
