package one_to_one.mainapp;

import net.datafaker.Faker;
import one_to_one.dao.ObjectDao;
import one_to_one.model.Parking;
import one_to_one.model.User;
import one_to_one.model.Vehicle;

public class MainApp {
    public static void main(String[] args) {
        ObjectDao.saveObject(getUser());
    }

    public static User getUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUserName(faker.name().name());
        user.setVehicle(getVehicle());
        user.setParking(getParking());
        user.getParking().setUser(user);
        return user;
    }

    public static Vehicle getVehicle() {
        Vehicle vehicle = new Vehicle();
        Faker faker = new Faker();
        vehicle.setVehicleName(faker.vehicle().model());
        return vehicle;
    }

    public static Parking getParking() {
        Faker faker = new Faker();
        Parking parking = new Parking();
        parking.setParkingName(faker.address().city());
        return parking;
    }
}
