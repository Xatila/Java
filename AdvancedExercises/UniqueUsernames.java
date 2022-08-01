package Test;
 
 
import java.util.*;
 
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }
 
        usernames.forEach(System.out::println);
        /*for (String username : usernames) {
            System.out.println(username);
        }*/
 
 
    }
}