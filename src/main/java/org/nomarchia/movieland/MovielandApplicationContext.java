package org.nomarchia.movieland;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:hibernate.properties"})
@ComponentScan("org.nomarchia.movieland")
@EnableJpaRepositories(basePackages = {"org.nomarchia.movieland.repository"})
@EnableTransactionManagement
public class MovielandApplicationContext {
    /*@Bean
    protected DataSource dataSource(@Value("${hibernate.connection.username}") String user, @Value("${hibernate.connection.password}") String password,
                                    @Value("${hibernate.connection.url}") String url, @Value("${hibernate.connection.driver_class}") String driver) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(user);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driver);

        return hikariDataSource;
    }*/

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("MovielandDb");

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory, DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource);
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}
