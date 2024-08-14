import java.sql.*;
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","951228");
             Statement statement = connection.createStatement()) {
            int i = statement.executeUpdate("insert into user (name,age) values ('小强',19)");
            Savepoint save1 = connection.setSavepoint();
            System.out.println("生效了:" + i);
            connection.rollback(save1);
            //Cloneable cloneable = arrs.reverse();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
