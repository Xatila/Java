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
        String input = scanner.nextLine(); //"1 2 3 4 5" -> split -> ["1", "2", "3", "4", "5"]
        List<Integer> numbers =  Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
 
        //обръщаме списъка
        Collections.reverse(numbers);
 
        //премахваме всички числа, които се делят на n
        //приема число -> true / false
        Predicate<Integer> checkDivision = number -> number % n == 0;
        numbers.removeIf(checkDivision);
 
        numbers.forEach(number -> System.out.print(number + " "));
 
 
 
    }
}