package iut.montreuil.config.dao;


import iut.montreuil.config.log.InfrastructureLogConfig;
import iut.montreuil.config.properties.PropertiesNameConfig;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        value = "iut.montreuil.infrastructure.adapter.repository")
@Import(value = {InfrastructureLogConfig.class})
public class DaoAppConfig {

    @Value("${conf.db.driver}")
    private String driver;
    @Value("${conf.db.url}")
    private String url;
    @Value("${conf.db.username}")
    private String username;
    @Value("${conf.db.password}")
    private String password;
    @Value("${conf.db.dialect}")
    private String dialect;
    @Value("${conf.db.show_sql}")
    private String showSql;
    //	@Value("${conf.network.db.default_schema}")
    private String schema;

    private final String packageToScanJpa =
            "iut.montreuil.infrastructure.adapter.entity";

    private static final Logger logger =
            LoggerFactory.getLogger(DaoAppConfig.class);

    @Resource
    private Environment env;

    @Bean
    public Properties hibProperties() {
        logger.info("Loading test properties.......");
        final Properties properties = new Properties();
        properties.put(PropertiesNameConfig.PROPERTY_NAME_HIBERNATE_DIALECT, dialect);
        properties.put(PropertiesNameConfig.PROPERTY_NAME_HIBERNATE_SHOW_SQL, showSql);
        properties.put(PropertiesNameConfig.PROPERTY_NAME_HIBERNATE_MAX_ACTIVE, "10");
        properties.put(PropertiesNameConfig.PROPERTY_NAME_HIBERNATE_MAX_IDLE, "10");
        properties.put(PropertiesNameConfig.PROPERTY_NAME_HIBERNATE_TEST, "true");
        properties.put(PropertiesNameConfig.PROPERTY_NAME_HIBERNATE_VALIDATION_QUERY, "SELECT 1");

        return properties;
    }

    @Bean
    public DataSource dataSource() {
        final DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(new String[] {packageToScanJpa});
        entityManagerFactoryBean.setJpaProperties(hibProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
