package theme9epatterns.task2;

import org.junit.jupiter.api.Test;
import theme9epatterns.task1.UserDAOImpl;

class ServiceTest {

    @Test
    void test() {
        UserService service = new UserServiceImpl(new UserDAOImpl());
        service.registration("Ilya", "Muromec", "Druzhina2024");
        service.authorization("Nikita", "Popovich00");
        service.authorization("Ilya", "Popovich00");
        service.authorization("Ilya", "Druzhina2024");
    }
}
