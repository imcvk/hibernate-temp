package Mapping_java_sql_Types;

import jakarta.persistence.*;
import lombok.*;

/**
 * The java.sql package contains JDBC types that are aligned with the types defined by the SQL standard:
 * <p>
 * Date corresponds to the DATE SQL type, which is only a date without time.
 * Time corresponds to the TIME SQL type, which is a time of the day specified in hours, minutes and seconds.
 * Timestamp includes information about date and time with precision up to nanoseconds and corresponds to the TIMESTAMP SQL type.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemporalValues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Basic
    private java.sql.Date sqlDate;

    @Basic
    private java.sql.Time sqlTime;

    @Basic
    private java.sql.Timestamp sqlTimestamp;

}