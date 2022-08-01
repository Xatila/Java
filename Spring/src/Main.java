import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.println("Password: ");
        String password = scanner.nextLine().trim();
        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
        PreparedStatement statement = connection.prepareStatement("SELECT m.name, m.age FROM villains as v JOIN minions_villains as mv ON v.id=mv.villain_id\n" +
                "JOIN minions as m ON m.id=mv.minion_id WHERE v.name = ?");

        /* Създаваме условие чрез java.
             String names = scanner.nextLine();
            statement.setString(1, (names));*/
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("name")+" "+rs.getString("count_minions"));
        }




    }
}
