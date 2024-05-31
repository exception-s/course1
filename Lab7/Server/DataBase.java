package Server;

import CollectionObjects.Objects.Address;
import CollectionObjects.Objects.Coordinates;
import CollectionObjects.Objects.Organization;
import CollectionObjects.Objects.OrganizationType;
import CollectionObjects.User;

import java.sql.*;
import java.util.Date;

public class DataBase {
    private static Connection connection;
    public static void setConnection(String URL, String username, String password) {
        try {
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Соединение с базой данных установлено.");
        } catch (SQLException e) {
            System.err.println("Не удалось установить соединение с базой данных.");
            e.printStackTrace();
        }
    }

    public static boolean checkUser(User user) {
        String query = "SELECT EXISTS(SELECT 1 FROM users WHERE username = ?)";
        try (PreparedStatement p = connection.prepareStatement(query)) {
            p.setString(1, user.getUsername());
            ResultSet result = p.executeQuery();
            if (result.next()) {
                return result.getBoolean(1);
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public static boolean checkPassword(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String query = "SELECT encryptedpassword FROM users WHERE username = ?";
        try (PreparedStatement p = connection.prepareStatement(query)){
            p.setString(1, username);
            ResultSet result = p.executeQuery();
            if (result.next()){
                String encryptedPassword = result.getString("encryptedpassword");
                return encryptedPassword.equals(password);
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public static boolean addUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String query = "INSERT INTO users (username, encryptedpassword) VALUES (?, ?)";
        try (PreparedStatement p = connection.prepareStatement(query)){
            p.setString(1, username);
            p.setString(2, password);
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static TheCollection getCollection() {
        String query = "SELECT organizations.id, organizations.name, organizations.x, organizations.y, organizations.creationdate, organizations.annualturnover," +
                "organizations.fullname, organizations.employeescount, organizations.type, organizations.street, " +
                "organizations.zipcode, organizations.userid FROM organizations";
        TheCollection collection = new TheCollection();
        try (PreparedStatement p = connection.prepareStatement(query)){
            ResultSet res = p.executeQuery();
            while (res.next()){
                try {
                    Organization org = new Organization();
                    org.setId(res.getInt(1));
                    org.setName(res.getString(2));
                    org.setCoordinates(new Coordinates(res.getLong(3), res.getLong(4)));
                    org.setDate(res.getDate(5));
                    org.setAnnualTurnover(res.getInt(6));
                    org.setFullName(res.getString(7));
                    org.setEmployeesCount(res.getInt(8));
                    org.setType(OrganizationType.valueOf(res.getString(9)));
                    org.setPostalAddress(new Address(res.getString(10), res.getString(11)));
                    org.setUserID(res.getInt(12));
                    collection.add(org);
                } catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
            }
            return collection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new TheCollection();
    }

    public static boolean addOrg(Organization organization, User user) {
        String query = "INSERT INTO organizations (name, x, y, creationdate, annualturnover, fullname, employeescount, type," +
                " street, zipcode, userid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT id FROM users WHERE username = ?))";
        try (PreparedStatement p = connection.prepareStatement(query)){
            p.setString( 1, organization.getName());
            p.setInt(2, (int) organization.getCoordinates().getX());
            p.setInt(3, Math.toIntExact(organization.getCoordinates().getY()));
            Date date = new Date();
            p.setDate(4, new java.sql.Date(date.getTime()));
            p.setInt(5, (int) organization.getAnnualTurnover());
            p.setString(6, organization.getFullName());
            p.setInt(7, (int) organization.getEmployeesCount());
            p.setString(8, organization.getType().toString());
            p.setString(9, organization.getPostalAddress().getStreet());
            p.setString(10, organization.getPostalAddress().getZipCode());
            p.setString(11, user.getUsername());
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean removeById(int id) {
        String query = "DELETE FROM organizations WHERE (id = ? AND userid IN (SELECT id FROM users WHERE username = ?))";
        try (PreparedStatement p = connection.prepareStatement(query)){
            p.setInt(1, id);
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean updateById(int id, Organization organization, User user) {
        String query = "UPDATE vehicles SET name = ?, x = ?, y = ?, creationdate = ?, annualturnover = ?, fullname = ?," +
                " employeescount = ?, type = ?, street = ?, zipcode = ? WHERE (id = ? AND userid IN (SELECT id FROM users WHERE username = ?))";
        try (PreparedStatement p = connection.prepareStatement(query)){
            p.setString(1, organization.getName());
            p.setLong(2, organization.getCoordinates().getX());
            p.setLong(3, organization.getCoordinates().getY());
            Date date = new Date();
            p.setDate(4, new java.sql.Date(date.getTime()));
            p.setLong(5, organization.getAnnualTurnover());
            p.setString(6, organization.getFullName());
            p.setLong(7, organization.getEmployeesCount());
            p.setString(8, organization.getType().toString());
            p.setString(9, organization.getPostalAddress().getStreet());
            p.setString(10, organization.getPostalAddress().getZipCode());
            p.setInt(11, id);
            p.setString(12, user.getUsername());
            p.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean clearCollection(User user) {
        String query = "DELETE FROM organizations WHERE userid IN (SELECT id FROM users WHERE username = ?)";
        try (PreparedStatement p = connection.prepareStatement(query)){
            p.setString(1, user.getUsername());
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
