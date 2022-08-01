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
 
        //начин 1:
        /*for (String name : names) {
            System.out.println(name);
        }*/
 
        //начин 2
        //name -> печатаме
        /*Consumer<String> printName = name -> System.out.println(name);
        for (String name : names) {
            printName.accept(name);
        }*/
 
        //начин 3
        //масив с имена -> печата
        Consumer<String> printName = name -> System.out.println(name);
        Consumer<String[]> printNames = array -> {
            for (String name : array) {
                printName.accept(name);
            }
        };
        printNames.accept(names);
 
 
    }
}