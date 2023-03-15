package one_to_one.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String UserName;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @OneToOne(cascade = CascadeType.ALL)
    Parking parking;
}
