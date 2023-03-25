package naitve_sql.dao;

import jakarta.persistence.Query;
import naitve_sql.HibernateConfiguration.HibernateConfiguration;
import naitve_sql.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class ObjectDaoNamedQuery {
    private final SessionFactory sessionFactory = null;
//    private String INSERTER = "INSERT INTO user u (userId, UserName) VALUES(?, ?, ?)";
//    private String UPDATER = "UPDATE user u SET u.UserName =? WHERE userId=?";
//    private String DELETER = "DELETE FROM user u WHERE u.userId=?";
//    private String SELECTOR = "SELECT * FROM user u WHERE u.userId=?";

    public static void saveObject(Object o) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
    }

    public static void updateUsingNamedNativeQuery(int id, String username) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedNativeQuery("UPDATER");
        query.setParameter("userId", id);
        query.setParameter("username", username);
        query.executeUpdate();
        transaction.commit();
    }

    public static void deleteUsingNamedNativeQuery(int id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedNativeQuery("DELETER");
        query.setParameter("userId", id);
        query.executeUpdate();
        transaction.commit();
    }

    public static void selectUsingNamedNativeQuery(int id) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Query query = session.getNamedNativeQuery("SELECTOR");
        query.setParameter("userId", id);
        List<Object> user = query.getResultList();
        for (Object o:user){
            System.out.println(o);
        }
    }
}
