package hql.mainapp;

import hql.dao.ObjectDao;
import hql.model.User;
import hql.model.Vehicle;
import net.datafaker.Faker;

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
