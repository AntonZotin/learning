package theme9epatterns.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void test() {
        UserDAO dao = new UserDAOImpl();
        dao.create(new User("Prohor", "Shalyapin", 28));
        dao.create(new User("Andrey", "Smetanov", 26));
        dao.create(new User("George", "Van Pussen", 2));

        Assertions.assertThrows(RuntimeException.class, () -> dao.get(4));
        System.out.println(dao.get(0));
        System.out.println(dao.get(1));
        System.out.println(dao.get(2));

        dao.delete(1);
        dao.update(2, new User("Michael", "Jackson", 89));

        System.out.println(dao.get(0));
        Assertions.assertThrows(RuntimeException.class, () -> dao.get(1));
        System.out.println(dao.get(2));
    }
}
