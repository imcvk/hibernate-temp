package one_to_many_unidirectional.mainapp;

import net.datafaker.Faker;
import one_to_many_unidirectional.dao.ObjectDao;
import one_to_many_unidirectional.model.Address;
import one_to_many_unidirectional.model.User;
import one_to_many_unidirectional.model.Vehicle;

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
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vehicles.add(getVehicle());
        }
        user.setVehicles(vehicles);
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            addresses.add(getAddress());
        }
        user.setAddresses(addresses);
        return user;
    }

    public static Vehicle getVehicle() {
        Vehicle vehicle = new Vehicle();
        Faker faker = new Faker();
        vehicle.setVehicleName(faker.vehicle().model());
        return vehicle;
    }

    public static Address getAddress() {
        Faker faker = new Faker();
        Address address = new Address();
        address.setAddress(faker.address().fullAddress());
        return address;
    }
}
