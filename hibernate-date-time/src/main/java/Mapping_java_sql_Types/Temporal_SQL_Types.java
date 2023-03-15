package Mapping_java_sql_Types;

import HibernateConfiguration.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Temporal_SQL_Types {
    public static void main(String[] args) {
        TemporalValues temporalValues = new TemporalValues();
        temporalValues.setSqlDate(java.sql.Date.valueOf("2017-11-15"));
        temporalValues.setSqlTime(java.sql.Time.valueOf("15:30:14"));
        temporalValues.setSqlTimestamp(
                java.sql.Timestamp.valueOf("2017-11-15 15:30:14.332"));
        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(temporalValues);
        transaction.commit();
    }
}
