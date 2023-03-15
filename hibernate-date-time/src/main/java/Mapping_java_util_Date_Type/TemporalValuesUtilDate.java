package Mapping_java_util_Date_Type;

import jakarta.persistence.*;
import lombok.*;

/**
 * The type java.util.Date contains both date and time information, up to millisecond precision.
 * But it doesn't directly relate to any SQL type.
 * The @Temporal annotation has the single parameter value of type TemporalType.
 * It can be either DATE, TIME or TIMESTAMP, depending on the underlying SQL type that we want to use for the mapping.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemporalValuesUtilDate {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date utilDate;

    @Basic
    @Temporal(TemporalType.TIME)
    private java.util.Date utilTime;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date utilTimestamp;
}
