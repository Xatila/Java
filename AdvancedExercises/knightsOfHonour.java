import java.util.Arrays;
import java.util.Scanner;
import java.util.function.*;
 
public class FormulaOne_02 {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> false / true -> test
        //BiFunction<приема1, приема2, връща> -> apply
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"Peter George Alex"
        String[] names = input.split("\\s+"); //["Peter", "George", "Alex"]
 
        //name -> отпечатвам Sir + name
        Consumer<String> printName = name -> System.out.println("Sir " + name);
        Arrays.stream(names).forEach(printName);
 
        /*for (String name : names) {
            printName.accept(name);
        }*/
 
 
 
    }
}