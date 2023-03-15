package one_to_many_bidirectional.dao;

import one_to_many_bidirectional.HibernateConfiguration.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ObjectDao {
    private SessionFactory sessionFactory = null;

    public static void saveObject(Object o) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
    }
}
