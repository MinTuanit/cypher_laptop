package com.example.cypher_laptop.config;

import com.example.cypher_laptop.repository.ProductRepository;
import com.example.cypher_laptop.repository.UserRepository;
import com.example.cypher_laptop.repository.auth.AuthUserRepository;
import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.cypher_laptop.repository", includeFilters = @ComponentScan.Filter(type = org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE, classes = {
                UserRepository.class,
                AuthUserRepository.class,
                ProductRepository.class
}), excludeFilters = @ComponentScan.Filter(type = org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE, classes = {
                }), entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef = "userTransactionManager")
public class UserDatabaseConfig {

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "spring.datasource.user")
        public DataSource userDataSource() {
                return DataSourceBuilder.create().build();
        }

        @Bean
        @Primary
        @DependsOn("userFlyway")
        public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
                        EntityManagerFactoryBuilder builder,
                        @Qualifier("userDataSource") DataSource dataSource) {
                return builder
                                .dataSource(dataSource)
                                .packages("com.example.cypher_laptop.entity.user",
                                                "com.example.cypher_laptop.entity.auth",
                                        "com.example.cypher_laptop.entity")
                                .persistenceUnit("user")
                                .build();
        }

        @Bean
        @Primary
        public PlatformTransactionManager userTransactionManager(
                        @Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
                return new JpaTransactionManager(entityManagerFactory);
        }

        @Bean(initMethod = "migrate")
        public Flyway userFlyway(@Qualifier("userDataSource") DataSource dataSource) {
                return Flyway.configure()
                                .dataSource(dataSource)
                                .locations("db/migration/user")
                                .baselineOnMigrate(true)
                                .baselineVersion("0")
                                .load();
        }
}