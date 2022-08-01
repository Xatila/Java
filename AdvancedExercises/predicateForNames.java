import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;
 
public class FormulaOne_02 {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> false / true -> test
        //BiFunction<приема1, приема2, връща> -> apply
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
       //name -> true/ false
        //true: length <= n
        //false: length > n
        Predicate<String> validLength = name -> name.length() <= n;
        String [] names = scanner.nextLine().split("\\s+"); //"Sara Sam George Mark John".split -> ["Sara", "Sam", ...]
 
        Arrays.stream(names).filter(validLength).forEach(System.out::println);
        //filter ->true: оставя; false: маха
        // оставя в списъка елементите, които отговарят на дадено условие
 
 
 
    }
}