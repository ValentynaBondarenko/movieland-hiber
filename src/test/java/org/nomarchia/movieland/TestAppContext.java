package org.nomarchia.movieland;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;
import java.time.Duration;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:hibernate.properties"})
public class TestAppContext {
    @Value("${migration.schema.location}")
    String migrationSchemaLocation;

    @Bean
    @Primary
    protected DataSource dataSource(@Value("${hibernate.connection.username}") String user,
                                    @Value("${hibernate.connection.password}") String password,
                                    @Value("${db.name}") String dbName) {
        PostgreSQLContainer<?> postgreSQLContainer = (PostgreSQLContainer<?>) new PostgreSQLContainer ("postgres:12")
                .withDatabaseName(dbName)
                .withUsername(user)
                .withPassword(password)
                /*.withStartupTimeout(Duration.ofSeconds(600))*/;

        postgreSQLContainer.start();


        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(postgreSQLContainer.getJdbcUrl());
        dataSource.setUser(postgreSQLContainer.getUsername());
        dataSource.setPassword(postgreSQLContainer.getPassword());

        Flyway flyway = Flyway.configure().dataSource(dataSource)
                .locations(migrationSchemaLocation).load();
        flyway.migrate();

        return dataSource;
    }
}
