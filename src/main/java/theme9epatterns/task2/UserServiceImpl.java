package theme9epatterns.task2;

import theme9epatterns.task1.User;
import theme9epatterns.task1.UserDao;
import theme9epatterns.task3.UserDto;

public class UserServiceImpl implements UserService {
    UserDao userDAO;

    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void registration(UserDto userDTO) {
        long id = userDAO.create(new User(userDTO.getName(), userDTO.getSurname(), userDTO.getPassword()));
        System.out.println("New user registered with id=" + id);
    }

    @Override
    public void authorization(UserDto userDTO) {
        User user = userDAO.findByName(userDTO.getName());
        if (user == null)
            System.out.println("User not found");
        else if (!user.getPassword().equalsIgnoreCase(userDTO.getPassword())) {
            System.out.println("Password incorrect");
        } else {
            System.out.println("Authorization of " + user.getName() + " successfully");
        }
    }
}
