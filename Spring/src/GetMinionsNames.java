import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetMinionsNames {
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


             int id = Integer.parseInt(scanner.nextLine());
            statement.setInt(1,(id));
        ResultSet rs = statement.executeQuery();
        int count = 1;
        if (!rs.next()){
            System.out.println("No villain with ID "+id+" exists in the database.");
        }else {
            System.out.println("Villain: ");
            while (rs.next()) {
                System.out.println(count + ". " + rs.getString("m.name") + " " + rs.getString("m.age"));
                count++;
            }
        }
    }
}
