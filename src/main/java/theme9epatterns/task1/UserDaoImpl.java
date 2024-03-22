package theme9epatterns.task1;

import java.util.HashMap;

public class UserDaoImpl implements UserDao {
    Long counter = 0L;
    HashMap<Long, User> users = new HashMap<>();

    @Override
    public long create(User user) {
        user.setId(this.counter++);
        users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public boolean update(long id, User user) {
        if (!users.containsKey(id))
            return false;
        User exist = users.get(id);
        exist.setName(user.getName());
        exist.setSurname(user.getSurname());
        exist.setPassword(user.getPassword());
        return true;
    }

    @Override
    public boolean delete(long id) {
        if (!users.containsKey(id))
            return false;
        users.remove(id);
        return true;
    }

    @Override
    public User get(long id) {
        if (!users.containsKey(id))
            return null;
        return users.get(id);
    }

    @Override
    public User findByName(String name) {
        for (User user: users.values()) {
            if (user.getName().equalsIgnoreCase(name))
                return user;
        }
        return null;
    }
}
