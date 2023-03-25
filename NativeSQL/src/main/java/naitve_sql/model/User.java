package naitve_sql.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedNativeQueries({
        @NamedNativeQuery(name = "UPDATER", query = "UPDATE user u SET u.UserName =:username WHERE userId=:userId"),
        @NamedNativeQuery(name = "DELETER", query = "DELETE FROM user u WHERE u.userId=:userId"),
        @NamedNativeQuery(name = "SELECTOR", query = "SELECT * FROM user u WHERE u.userId=:userId",resultClass = User.class)
}
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String UserName;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}
