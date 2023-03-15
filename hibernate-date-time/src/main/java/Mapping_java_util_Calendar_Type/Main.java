package Mapping_java_util_Calendar_Type;

import HibernateConfiguration.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        TemporalValuesCalendarType temporalValues = new TemporalValuesCalendarType();
        Calendar calendarDate = Calendar.getInstance(
                TimeZone.getTimeZone("UTC"));
        calendarDate.set(Calendar.YEAR, 2017);
        calendarDate.set(Calendar.MONTH, 10);
        calendarDate.set(Calendar.DAY_OF_MONTH, 15);
        temporalValues.setCalendarDate(calendarDate);

        Calendar calendarTime = Calendar.getInstance(
                TimeZone.getTimeZone("UTC"));
        calendarTime.set(Calendar.YEAR, 2017);
        calendarTime.set(Calendar.MONTH, 10);
        calendarTime.set(Calendar.DAY_OF_MONTH, 15);
        calendarTime.setTime(new Date());
        temporalValues.setCalendarTimestamp(calendarTime);

        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(temporalValues);
        transaction.commit();
    }
}
