package theme9epatterns.task2;

import theme9epatterns.task1.User;
import theme9epatterns.task1.UserDAO;

public class UserServiceImpl implements UserService {
    UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void registration(String name, String surname, String password) {
        long id = userDAO.create(new User(name, surname, password));
        System.out.println("New user registered with id=" + id);
    }

    @Override
    public void authorization(String name, String password) {
        User user = userDAO.findByName(name);
        if (user == null)
            System.out.println("User not found");
        else if (!user.getPassword().equalsIgnoreCase(password)) {
            System.out.println("Password incorrect");
        } else {
            System.out.println("Authorization of " + user.getName() + " successfully");
        }
    }
}
