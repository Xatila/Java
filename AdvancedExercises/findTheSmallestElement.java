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
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
 
        //начин 1
        //приемаме списък -> отпечатваме индексът на най-малкото число
        /*Consumer<List<Integer>> printIndexOfMinElement = list -> {
            int min = Collections.min(list);
            System.out.println(list.lastIndexOf(min));
        };
 
        printIndexOfMinElement.accept(numbers);*/
 
        //приемаме списък -> връщаме индексът на най-малкото число
        Function<List<Integer>, Integer> getIndexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(getIndexOfMinElement.apply(numbers));
 
 
 
    }
}