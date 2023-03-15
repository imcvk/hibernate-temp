package many_to_many.mainapp;

import many_to_many.dao.ObjectDao;
import many_to_many.model.User;
import many_to_many.model.Vehicle;
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
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Vehicle vehicle = getAddress(faker);
            vehicles.add(vehicle);
        }
        user.setVehicles(vehicles);
        return user;
    }
    public static Vehicle getAddress(Faker faker) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName(faker.name().name());
        return vehicle;
    }
}
