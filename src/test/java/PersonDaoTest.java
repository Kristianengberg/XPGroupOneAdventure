import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.Person;
import sample.PersonDao;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PersonDaoTest {

    @Mock
    private DataSource ds;
    @Mock
    private Connection c;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet rs;
    @Mock
    private PersonDao personDao;

    private Person p;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        assertNotNull(ds);
        personDao = new PersonDao(ds);

        p = new Person();
        p.setId(1);
        p.setFirstName("Johannes");
        p.setLastName("Schmeckel");
    }

    @Test
    public void nullCreateThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            new PersonDao(ds).create(null);
        });
    }

    @Test
    public void createPerson() throws SQLException {
        personDao = new PersonDao(ds);
        when(c.prepareStatement("INSERT INTO person (id, first_name, last_name) values (?, ?, ?)")).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);

        assertEquals(p, personDao.create(p));
    }

    @Test
    public void updatePerson() throws SQLException {
        personDao = new PersonDao(ds);
        when(c.prepareStatement("UPDATE person SET first_name=?, last_name=? WHERE id=?")).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);
        p.setFirstName("John");
        p.setLastName("Winchester");

        assertEquals(p, personDao.update(p));
    }

    @Test
    public void deletePerson() throws SQLException {
        personDao = new PersonDao(ds);
        when(c.prepareStatement("DELETE FROM person WHERE id=?")).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);

        Person p1 = new Person();
        p1.setId(1);

        assertTrue(personDao.delete(p1));
    }

    @Test
    public void createAndRetrievePerson() throws SQLException {
        when(c.prepareStatement("SELECT id, first_name, last_name FROM person WHERE id = ?")).thenReturn(stmt);
        when(c.prepareStatement("INSERT INTO person (id, first_name, last_name) values (?, ?, ?)")).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);
        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(p.getFirstName());
        when(rs.getString(3)).thenReturn(p.getLastName());
        when(stmt.executeQuery()).thenReturn(rs);

        PersonDao dao = new PersonDao(ds);
        dao.create(p);
        Person r = dao.retrieve(1);
        assertEquals(p.getId(), r.getId());
        assertEquals(p.getFirstName(), r.getFirstName());
        assertEquals(p.getLastName(), r.getLastName());
    }

}
