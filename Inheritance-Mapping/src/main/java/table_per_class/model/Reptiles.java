package table_per_class.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("reptiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reptiles extends Animal {
    String breed;
    String noOfLegs;
}
