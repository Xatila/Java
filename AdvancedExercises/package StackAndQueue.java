package StackAndQueue;
 
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. всички числа да ги сложа в стек
        //2. вадя числата от стека -> стоп: стекът стане празен
 
        //"1 2 3 4 5"
        String [] inputNumbers = scanner.nextLine().split("\\s+"); //["1", "2", "3", "4", "5"]
        ArrayDeque<String> stack = new ArrayDeque<>();
 
        for (String number : inputNumbers) {
            stack.push(number);
        }
 
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}