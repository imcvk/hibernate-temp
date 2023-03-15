package many_to_many_mapping_in_another_column.model;

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
    @ManyToMany(cascade = CascadeType.ALL)
    List<User> users;
}
