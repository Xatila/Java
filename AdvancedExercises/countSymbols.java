import java.util.*;

public class Sets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> theMap = new TreeMap<>();
        String text = scanner.nextLine();
        for (int i = 0; i <text.length() ; i++) {
            char current = text.charAt(i);
           if (theMap.containsKey(current)){
               int currentCount = theMap.get(current);
               theMap.put(current, currentCount+1);
           }else {
               theMap.put(current, 1);
           }
        }
        theMap.entrySet().forEach(entry-> System.out.println(entry.getKey()+": "+entry.getValue()+" time/s"));


    }
}
