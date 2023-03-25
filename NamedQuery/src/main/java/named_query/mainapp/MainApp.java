package named_query.mainapp;

import named_query.dao.ObjectDaoNamedQuery;
import named_query.model.User;
import net.datafaker.Faker;

public class MainApp {
    public static void main(String[] args) {
        // ObjectDao.fetUsingNamedQuery();
        //ObjectDaoNamedQuery.fetchUsingNamedQueryWithId(1);
        ObjectDaoNamedQuery.updateUsingNamedQuery(1);
        ObjectDaoNamedQuery.deleteUsingNamedQuery(152);
    }

    public static User getUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUserName(faker.name().name());

        return user;
    }
}
