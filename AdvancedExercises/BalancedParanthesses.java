package StackAndQueue;
 
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Последната отворена да съвпада с първата затворена
        String input = scanner.nextLine(); //"{[()]}"
 
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean areBalanced = false; //дали скобите са ни балансирани
        for (int index = 0; index < input.length(); index++) {
            char currentBracket = input.charAt(index);
            //проверка дали скобата е отворена -> {, [, (
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBrackets.push(currentBracket);
            } //проверка дали скобата е затворена
            else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                //currentBracket -> затворена скоба
                //проверка дали тази затворена скоба съвпада с послендата отворена
                if (openBrackets.isEmpty()) { //нямам отворени скоби
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = openBrackets.pop(); //последната отворена скоба
                //отворена ( и затворена )
                if (lastOpenBracket == '(' && currentBracket == ')') {
                    //balance
                    areBalanced = true;
                }
                //отворена { и затворена }
                else if (lastOpenBracket == '{' && currentBracket == '}') {
                    //balance
                    areBalanced = true;
                }
                //отворена [ и затворена ]
                else if (lastOpenBracket == '[' && currentBracket == ']') {
                    //balance
                    areBalanced = true;
                } else {
                    //no balance
                    areBalanced = false;
                    break;
                }
            }
        }
 
        //проверка дали имаме баланс при всички скоби
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}