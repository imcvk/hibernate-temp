package custom_generator;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "USERDETAILS1")
public class UserCustomGenerator {
    @Id
    @GenericGenerator(name = "userid", strategy = "custom_generator.ID_Generator")
    @GeneratedValue(generator = "userid")
    @Column(name = "USERID")
    String userid;
    @Column(name = "USERNAME")
    String name;
    @Column(name = "USEREMAIL")
    String userEmail;
    @Column(name = "USERPHONENO")
    String phoneNumber;
}
