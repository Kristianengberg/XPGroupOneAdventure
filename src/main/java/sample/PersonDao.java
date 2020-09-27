package sample;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class PersonDao {

    private DataSource ds;

    public PersonDao(DataSource ds) {
        this.ds = ds;
    }

    public Person create(Person person) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("INSERT INTO person (id, first_name, last_name) values (?, ?, ?)");
            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getLastName());
            stmt.executeUpdate();
            c.close();
            return person;
        } catch (SQLException e) {
            System.out.println(e);

        }
        return new Person();
    }

    public Person retrieve(int id) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c.prepareStatement("SELECT id, first_name, last_name FROM person WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.first()) {
                return null;
            }
            Person p = new Person();
            p.setId(rs.getInt(1));
            p.setFirstName(rs.getString(2));
            p.setLastName(rs.getString(3));
            c.close();
            return p;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new Person();
    }

    public Person update(Person person) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("UPDATE person SET first_name=?, last_name=? WHERE id=?");
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setInt(3, person.getId());
            stmt.executeUpdate();
            c.close();
            return person;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new Person();
    }

    public boolean delete(Person person) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("DELETE FROM person WHERE id=?");
            stmt.setInt(1, person.getId());
            stmt.executeUpdate();
            c.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
