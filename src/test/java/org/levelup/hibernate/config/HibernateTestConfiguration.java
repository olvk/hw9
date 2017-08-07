package org.levelup.hibernate.config;


import lesson9.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import sun.security.krb5.Config;

import javax.security.auth.login.Configuration;
import java.util.Properties;

public class HibernateTestConfiguration {

    private static final SessionFactory FACTORY = buildFactory();

    private static SessionFactory buildFactory() {
        final ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(defineHibernateSettings()).build();
       return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory(registry);

    }

    private static Properties defineHibernateSettings() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:h2:mem:posts/postschema?INIT=create schema if not exists postschema");
        properties.setProperty("hibernate.connection.username", "sa");
        properties.setProperty("hibernate.connection.password", "");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true"); //показывает генерируемые sql запросы
        properties.setProperty("hibernate.format_sql", "true"); //поделит их по блокам

        return properties;
    }

    public static SessionFactory getFactory() {return FACTORY;}

    public static void main(String[] args) {

    }

}
