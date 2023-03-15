package Mapping_java_util_Date_Type;

import HibernateConfiguration.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        TemporalValuesUtilDate temporalValuesUtilDate = new TemporalValuesUtilDate();
        try {
            temporalValuesUtilDate.setUtilDate(
                    new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"));
            temporalValuesUtilDate.setUtilTime(
                    new SimpleDateFormat("HH:mm:ss").parse("15:30:14"));
            temporalValuesUtilDate.setUtilTimestamp(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                            .parse("2017-11-15 15:30:14.332"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(temporalValuesUtilDate);
        transaction.commit();
        /**
         * the java.util.Date type (milliseconds precision) is not precise enough to handle the Timestamp value (nanoseconds precision).
         * So, when we retrieve the entity from the database,
         * we'll unsurprisingly find a java.sql.Timestamp instance in this field, even if we initially persisted a java.util.Date:
         * */
        TemporalValuesUtilDate t = new TemporalValuesUtilDate();
        t = session.get(TemporalValuesUtilDate.class,
                temporalValuesUtilDate.getId());
        System.out.println(t);
    }
}
