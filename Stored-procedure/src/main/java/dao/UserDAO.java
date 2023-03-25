package dao;

import config.HibernateConfiguration;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.criteria.CriteriaBuilder;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.procedure.ProcedureParameter;

import java.util.Arrays;
import java.util.List;

public class UserDAO {
    public static SessionFactory sessionFactory = null;
    public static Session session = null;

    public static void saveObject(Object o) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
    }

    public static void initSession() {
        sessionFactory = HibernateConfiguration.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public static void callStoredProc() {
        initSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("getAllUsers", User.class);
        List<User> users = procedureCall.getResultList();
        users.forEach(System.out::println);
    }

    public static void callProcWithParameter(int sal) {
        initSession();
        ProcedureCall call = session.createStoredProcedureCall("getUserWithGreaterSal");
        ProcedureParameter<Integer> in_parameter = call.registerParameter(1, Integer.class, ParameterMode.IN);
        call.setParameter(in_parameter, sal);

    }


}
