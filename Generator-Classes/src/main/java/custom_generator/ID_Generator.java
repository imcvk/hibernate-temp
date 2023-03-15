package custom_generator;

import com.github.javafaker.Faker;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.Random;

public class ID_Generator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Faker faker = new Faker();
        String id = "USERID" + faker.number().numberBetween(1111, 9999);
        return id;
    }
}
