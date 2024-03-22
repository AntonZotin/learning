package theme9epatterns.task1;

import java.util.HashMap;

public class UserDAOImpl implements UserDAO {
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
            throw new RuntimeException("Not found user id");
        User exist = users.get(id);
        exist.setName(user.getName());
        exist.setSurname(user.getSurname());
        exist.setBirthDay(user.getBirthDay());
        return true;
    }

    @Override
    public User get(long id) {
        if (!users.containsKey(id))
            throw new RuntimeException("Not found user id");
        return users.get(id);
    }

    @Override
    public boolean delete(long id) {
        if (!users.containsKey(id))
            throw new RuntimeException("Not found user id");
        users.remove(id);
        return true;
    }
}
