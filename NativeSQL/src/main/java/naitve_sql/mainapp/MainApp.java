package naitve_sql.mainapp;

import naitve_sql.dao.ObjectDaoNamedQuery;
import naitve_sql.model.User;
import net.datafaker.Faker;

public class MainApp {
    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            ObjectDaoNamedQuery.saveObject(getUser());
//        }
        ObjectDaoNamedQuery.updateUsingNamedNativeQuery(1, "TestNamed");
        ObjectDaoNamedQuery.deleteUsingNamedNativeQuery(52);
        ObjectDaoNamedQuery.selectUsingNamedNativeQuery(1);
    }

    public static User getUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUserName(faker.name().name());

        return user;
    }
}
