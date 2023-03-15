package Mapping_java_time_Types;

import jakarta.persistence.*;
import lombok.*;
/**
 * Since Java 8, the new Java Date and Time API is available for dealing with temporal values. This API fixes many of
 * the problems of java.util.Date and java.util.Calendar classes.
 * The types from the java.time package are directly mapped to corresponding SQL types.
 * So, there's no need to explicitly specify @Temporal annotation:
 * LocalDate is mapped to DATE.
 * LocalTime and OffsetTime are mapped to TIME.
 * Instant, LocalDateTime, OffsetDateTime and ZonedDateTime are mapped to TIMESTAMP.
 *
 * */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TemporalValuesLocalDate {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    @Basic
    private java.time.LocalDate localDate;

    @Basic
    private java.time.LocalTime localTime;

    @Basic
    private java.time.OffsetTime offsetTime;

    @Basic
    private java.time.Instant instant;

    @Basic
    private java.time.LocalDateTime localDateTime;

    @Basic
    private java.time.OffsetDateTime offsetDateTime;

    @Basic
    private java.time.ZonedDateTime zonedDateTime;
}
