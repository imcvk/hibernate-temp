package single_table_per_hierarchy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import single_table_per_hierarchy.config.HibernateConfiguration;

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
