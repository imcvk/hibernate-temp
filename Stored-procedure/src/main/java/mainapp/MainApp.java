package mainapp;

import com.github.javafaker.Faker;
import dao.UserDAO;
import model.User;

public class MainApp {
    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            UserDAO.saveObject(createUserObject());
//        }

        //UserDAO.callStoredProc();
        UserDAO.callProcWithParameter(5000);
    }

    public static User createUserObject() {
        User user = new User();
        Faker faker = new Faker();
        user.setUserName(faker.name().name());
        user.setUserEmail(user.getUserName() + "@gmail.com");
        user.setUserPh(faker.phoneNumber().cellPhone());
        user.setUserSal(faker.number().numberBetween(11111, 99999));
        return user;
    }

}
