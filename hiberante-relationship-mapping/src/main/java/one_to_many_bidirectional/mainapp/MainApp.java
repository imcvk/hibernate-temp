package one_to_many_bidirectional.mainapp;

import net.datafaker.Faker;
import one_to_many_bidirectional.dao.ObjectDao;
import one_to_many_bidirectional.model.Address;
import one_to_many_bidirectional.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ObjectDao.saveObject(getUser());
    }

    public static User getUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUserName(faker.name().name());

        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Address address = getAddress();
            address.setUser(user);
            addresses.add(address);
        }
        user.setAddresses(addresses);
        return user;
    }


    public static Address getAddress() {
        Faker faker = new Faker();
        Address address = new Address();
        address.setAddress(faker.address().fullAddress());
        return address;
    }
}
