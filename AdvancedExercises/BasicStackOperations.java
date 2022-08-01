package StackAndQueue;
 
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //n -> брой на числа за добавяне -> брой пъти push в stack
        //s -> брой на числа за премахване -> брой пъти pop в stack
        //х -> проверка дали го има в стека -> true / min element in stack
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
 
        //n на брой пъти да добавяме
        for (int count = 1; count <= n; count++) {
            stack.push(scanner.nextInt());
        }
 
        //s на брой пъти да премахваме
        for (int count = 1; count <= s; count++) {
            stack.pop();
        }
 
        //x го има в стека
        if (stack.contains(x)) {
            System.out.println("true");
        } else { //x го няма в стека
            //имаме елементи
            if (!stack.isEmpty()) {
                //мин елемент
                System.out.println(Collections.min(stack));
            } else {
                System.out.println(0);
            }
        }
 
 
    }
}