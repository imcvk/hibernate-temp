package many_to_many.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int vehicleId;
    String vehicleName;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "vehicles")
    List<User> users;
}
