package edu.utn.autos.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@PropertySource(value="classpath:configuration.properties")
public class AppConfiguration {

    @Primary
    @Bean("con1")
    public Connection getConnection(@Value("${db.url}") String url,
                                    @Value("${db.name}") String dbname,
                                    @Value("${db.user}") String user,
                                    @Value("${db.password}") String password) throws SQLException, ClassNotFoundException {
        return DriverManager.
                getConnection("jdbc:mysql://"+url+"/"+dbname, user, password);
    }

    @Bean("con2")
    public Connection getConnection2(@Value("${db.url}") String url,
                                    @Value("${db.name}") String dbname,
                                    @Value("${db.user}") String user,
                                    @Value("${db.password}") String password) throws SQLException, ClassNotFoundException {
        return DriverManager.
                getConnection("jdbc:mysql://"+url+"/"+dbname, user, password);
    }

}
