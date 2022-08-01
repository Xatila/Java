import java.util.*;

public class Sets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> mapData = new LinkedHashMap<>();
        while (!name.equals("stop")) {
            String mail = scanner.nextLine();
            if (!mail.endsWith("uk") && !mail.endsWith("com") && !mail.endsWith("us")) {
                mapData.put(name, mail);
            }
            name = scanner.nextLine();
        }
        mapData.entrySet().forEach(entry-> System.out.println(entry.getKey()+" -> "+entry.getValue()));

    }
}
