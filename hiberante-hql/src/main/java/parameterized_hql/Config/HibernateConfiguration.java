package parameterized_hql.Config;

import hql.model.User;
import hql.model.Vehicle;
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
            p.put(Environment.HBM2DDL_AUTO, "update");
            p.put(Environment.SHOW_SQL, true);
            configuration.setProperties(p);
            configuration.addAnnotatedClass(User.class).addAnnotatedClass(Vehicle.class);
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

