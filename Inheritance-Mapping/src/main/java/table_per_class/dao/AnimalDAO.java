package table_per_class.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import table_per_class.config.HibernateConfiguration;

public class AnimalDAO {
    public static SessionFactory sessionFactory = null;

    public static void saveAnimal(Object o) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
    }
}
