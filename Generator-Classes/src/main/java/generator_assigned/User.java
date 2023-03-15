package generator_assigned;

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
@Table(name = "USERDETAILS")
public class User {
    @Id
    @Column(name = "USERID")
    int userid;
    @Column(name = "USERNAME")
    String name;
    @Column(name = "USEREMAIL")
    String userEmail;
    @Column(name = "USERPHONENO")
    String phoneNumber;
}
