package theme9epatterns.task1;

public interface UserDao {
    long create(User user);
    boolean update(long id, User user);
    boolean delete(long id);
    User get(long id);
    User findByName(String name);
}
