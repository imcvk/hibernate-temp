package many_to_many.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    /**
     * Using Link Table
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;
}
