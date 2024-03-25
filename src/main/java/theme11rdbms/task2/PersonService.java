package theme11rdbms.task2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class PersonService implements AutoCloseable {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonService() {
        emf = Persistence.createEntityManagerFactory("connection");
        em = emf.createEntityManager();
    }

    public void createPerson(Person person) {
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        }
    }

    public List<Person> personList() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    public void close() {
        if (em != null)
            em.close();
        if (emf != null)
            emf.close();
    }
}
