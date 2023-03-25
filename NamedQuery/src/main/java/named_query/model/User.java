package named_query.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@NamedQuery(name = "selectAllUsers", query = "from User")
@NamedQueries({
        @NamedQuery(name = "selectUsingId", query = "from User u where u.id=:id"),
        @NamedQuery(name = "updateUser", query = "UPDATE User u SET u.UserName ='test test' where u.userId=:id"),
        @NamedQuery(name = "deleteUser", query = "DELETE FROM User u WHERE u.userId=:id")
}
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String UserName;
}
