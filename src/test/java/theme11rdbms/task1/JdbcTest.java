package theme11rdbms.task1;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JdbcTest {

    @Test
    void test() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/test", "admin", "nimda"
        )) {
            try {
                final String INSERT = "INSERT INTO users (id, name, email) VALUES (?, ?, ?);";
                PreparedStatement statement = connection.prepareStatement(INSERT);
                statement.setInt(1, 1);
                statement.setString(2, "user1");
                statement.setString(3, "user1@mail.ru");
                int rows = statement.executeUpdate();
                System.out.printf("%d rows added\n", rows);

                ResultSet resultSet = connection.prepareStatement("SELECT * FROM users").executeQuery();
                while (resultSet.next()) {
                    Assertions.assertEquals(1, resultSet.getInt("id"));
                    Assertions.assertEquals("user1", resultSet.getString("name"));
                    Assertions.assertEquals("user1@mail.ru", resultSet.getString("email"));
                }

                statement = connection.prepareStatement(INSERT);
                statement.setInt(1, 2);
                statement.setString(2, null);
                statement.setString(3, "user2@mail.ru");
                statement.addBatch();
                statement.setInt(1, 3);
                statement.setString(2, "user3");
                statement.setString(3, null);  // email NOT NULL
                statement.addBatch();

                try {
                    statement.executeBatch();
                } catch (BatchUpdateException e) {
                    Assertions.assertTrue(e.getMessage().contains("нарушает ограничение NOT NULL"));
                }
                resultSet = connection.prepareStatement("SELECT COUNT(*) FROM users;").executeQuery();
                while (resultSet.next()) {
                    Assertions.assertEquals(1, resultSet.getInt(1));
                }

                statement = connection.prepareStatement(INSERT);
                statement.setInt(1, 2);
                statement.setString(2, null);
                statement.setString(3, "user2@mail.ru");
                statement.addBatch();
                statement.setInt(1, 3);
                statement.setString(2, "user3");
                statement.setString(3, "user3@mail.ru");  // fixed
                statement.addBatch();

                rows = statement.executeBatch().length;
                System.out.printf("%d rows added\n", rows);

                resultSet = connection.prepareStatement("SELECT COUNT(*) FROM users;").executeQuery();
                while (resultSet.next()) {
                    Assertions.assertEquals(3, resultSet.getInt(1));
                }

            } finally {
                connection.prepareStatement("TRUNCATE TABLE users;").executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
