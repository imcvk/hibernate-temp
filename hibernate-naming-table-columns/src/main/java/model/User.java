package model;

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
@Table(name = "user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USERID")
    int userid;
    @Column(name = "USERNAME")
    String name;
    @Column(name = "USEREMAIL")
    String userEmail;
    @Column(name = "USERPHONENO")
    String phoneNumber;
}
