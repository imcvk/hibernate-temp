package table_per_class.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("mammals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mammals extends Animal {
    String breed;
    String noOfLegs;
}
