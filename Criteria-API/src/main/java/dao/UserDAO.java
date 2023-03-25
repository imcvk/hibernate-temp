package dao;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    public static SessionFactory sessionFactory = null;
    public static Session session = null;
    public static CriteriaBuilder criteriaBuilder = null;

    public static void saveObject(Object o) {
        Session session = Config.HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
    }

    public static void initSession() {
        sessionFactory = Config.HibernateConfiguration.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public static void selectAll() {
        initSession();
        criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        //for pagination
        //query.setMaxResults(10);
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }

    public static void selectUnique(int id) {
        initSession();
        criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), "1"));
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }

    public static void selectBasedOnSalary() {
        initSession();
        criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.ge(root.get("userSal"), 52670.0));
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }
    public static void multiSelect(){
        initSession();
        criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.multiselect(root.get("id"),root.get("userName"));
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        users.forEach(System.out::println);
    }
}
