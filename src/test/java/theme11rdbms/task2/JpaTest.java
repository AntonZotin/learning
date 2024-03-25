package theme11rdbms.task2;

import java.util.List;
import javax.persistence.PersistenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JpaTest {
    @Test
    void test() {
        try (PersonService service = new PersonService()) {
            List<Person> list = service.personList();
            Assertions.assertEquals(0, list.size());

            service.createPerson(new Person("Igor", "igor@mail.ru"));
            list = service.personList();
            Assertions.assertEquals(1, list.size());
            Assertions.assertEquals("Igor", list.get(0).getName());
            Assertions.assertEquals("igor@mail.ru", list.get(0).getEmail());

            Assertions.assertThrows(
                    PersistenceException.class,
                    () -> service.createPerson(new Person("Igor", null))
            );
            list = service.personList();
            Assertions.assertEquals(1, list.size());
        }
    }
}
