package theme9epatterns.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void test() {
        UserDAO dao = new UserDAOImpl();
        dao.create(new User("Prohor", "Shalyapin", "pass"));
        dao.create(new User("Andrey", "Smetanov", "sapp"));
        dao.create(new User("George", "Van Pussen", "pes"));

        Assertions.assertNull(dao.get(4));
        System.out.println(dao.get(0));
        System.out.println(dao.get(1));
        System.out.println(dao.get(2));

        dao.delete(1);
        dao.update(2, new User("Michael", "Jackson", "wow"));

        System.out.println(dao.get(0));
        Assertions.assertNull(dao.get(1));
        System.out.println(dao.get(2));
    }
}
