package one_to_one.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * This class implements multi-directional mechanism with user entiry
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int parkingId;
    String parkingName;
    @OneToOne
    User user;
}
