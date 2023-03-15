package HibernateConfiguration;

import custom_generator.UserCustomGenerator;
import generator_IDENTITY.User_IDENTITY;
import generator_assigned.User;
import generator_AUTO.User_AUTO;
import generator_SEQUENCE.User_SEQUENCE;
import generator_TABLE.User_Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfiguration {
    public static SessionFactory sessionFactory = null;
    public static Session session = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties p = new Properties();
            p.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
            p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            p.put(Environment.USER, "root");
            p.put(Environment.PASS, "root");
            p.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            p.put(Environment.HBM2DDL_AUTO, "create");
            p.put(Environment.SHOW_SQL, true);
            configuration.setProperties(p);
            configuration.addAnnotatedClass(User.class).addAnnotatedClass(User_SEQUENCE.class).addAnnotatedClass(User_Table.class)
                    .addAnnotatedClass(User_AUTO.class).addAnnotatedClass(User_IDENTITY.class).addAnnotatedClass(UserCustomGenerator.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public static Session getSession() {
        session = getSessionFactory().openSession();
        return session;
    }
}

