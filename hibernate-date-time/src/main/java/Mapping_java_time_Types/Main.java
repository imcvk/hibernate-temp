package Mapping_java_time_Types;

import HibernateConfiguration.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        TemporalValuesLocalDate temporalValuesLocalDate = new TemporalValuesLocalDate();
        temporalValuesLocalDate.setLocalDate(LocalDate.parse("2017-11-15"));

        temporalValuesLocalDate.setLocalTime(LocalTime.parse("15:30:18"));
        temporalValuesLocalDate.setOffsetTime(OffsetTime.parse("08:22:12+01:00"));

        temporalValuesLocalDate.setInstant(Instant.parse("2017-11-15T08:22:12Z"));
        temporalValuesLocalDate.setLocalDateTime(
                LocalDateTime.parse("2017-11-15T08:22:12"));
        temporalValuesLocalDate.setOffsetDateTime(
                OffsetDateTime.parse("2017-11-15T08:22:12+01:00"));
        temporalValuesLocalDate.setZonedDateTime(
                ZonedDateTime.parse("2017-11-15T08:22:12+01:00[Europe/Paris]"));

        Session session = HibernateConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(temporalValuesLocalDate);
        transaction.commit();
    }
}
