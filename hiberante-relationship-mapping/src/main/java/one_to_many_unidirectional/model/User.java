package one_to_many_unidirectional.model;

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
     * Using Foreign Key Association
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Vehicle> vehicles;
    /**
     * Using Link Table
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address")
    private List<Address> addresses;



}
