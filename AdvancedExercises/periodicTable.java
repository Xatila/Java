package Test;
 
import java.util.*;
 
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
 
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine(); // "Mo O Ce", "Ge Ch O Ne"
            String[] inputElements = input.split("\\s+");//["Mo", "O", "Ce"]
 
            //начин 1
           /* for (String el : inputElements) {
                elements.add(el);
            }*/
 
            //начин 2
            //Collections.addAll(elements, inputElements);
 
            //начин 3
            elements.addAll(Arrays.asList(inputElements));
        }
 
        elements.forEach(el -> System.out.print(el + " "));
 
    }
}