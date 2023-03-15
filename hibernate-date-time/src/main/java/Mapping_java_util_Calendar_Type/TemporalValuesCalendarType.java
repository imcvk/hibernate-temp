package Mapping_java_util_Calendar_Type;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemporalValuesCalendarType {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar calendarDate;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar calendarTimestamp;
}
