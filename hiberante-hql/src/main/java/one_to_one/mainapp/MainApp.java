package one_to_one.mainapp;

import net.datafaker.Faker;
import one_to_one.dao.ObjectDao;
import one_to_one.model.User;
import one_to_one.model.Vehicle;

public class MainApp {
    public static void main(String[] args) {
        User user = getUser();
        user.setUserId(1000);
        ObjectDao.saveObject(user);
//        ObjectDao.fetchAll();
//        ObjectDao.fetchSingle();
        ObjectDao.deleteUsingHQL();
    }

    public static User getUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUserName(faker.name().name());
        user.setVehicle(getVehicle());
        return user;
    }

    public static Vehicle getVehicle() {
        Vehicle vehicle = new Vehicle();
        Faker faker = new Faker();
        vehicle.setVehicleName(faker.vehicle().model());
        return vehicle;
    }
}
