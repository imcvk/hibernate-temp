package many_to_one.mainapp;

import many_to_one.dao.ObjectDao;
import many_to_one.model.Address;
import many_to_one.model.User;
import net.datafaker.Faker;


import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Faker faker = new Faker();
        ObjectDao.saveObject(getUser(faker));
    }

    public static User getUser(Faker faker) {
        User user = new User();
        user.setUserName(faker.name().name());
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Address address = getAddress(faker);
            address.setUser(user);
            addresses.add(address);
        }
        user.setAddresses(addresses);
        return user;
    }
    public static Address getAddress(Faker faker) {
        Address address = new Address();
        address.setAddress(faker.address().fullAddress());
        return address;
    }
}
