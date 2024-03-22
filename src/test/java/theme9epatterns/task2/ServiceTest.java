package theme9epatterns.task2;

import org.junit.jupiter.api.Test;
import theme9epatterns.task1.UserDaoImpl;
import theme9epatterns.task3.UserDto;

class ServiceTest {

    @Test
    void test() {
        UserService service = new UserServiceImpl(new UserDaoImpl());
        service.registration(new UserDto("Ilya", "Muromec", "Druzhina2024"));
        service.authorization(new UserDto("Nikita", "Popovich00"));
        service.authorization(new UserDto("Ilya", "Popovich00"));
        service.authorization(new UserDto("Ilya", "Druzhina2024"));
    }
}
