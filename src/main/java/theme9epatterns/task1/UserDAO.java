package theme9epatterns.task1;

public interface UserDAO {
    long create(User user);
    boolean update(long id, User user);
    User get(long id);
    boolean delete(long id);
}
