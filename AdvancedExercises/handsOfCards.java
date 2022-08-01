package Test;
 
import java.util.*;
 
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //име на човек -> списък с карти (уникални карти -> set)
        LinkedHashMap<String, Set<String>> playersCards = new LinkedHashMap<>();
 
        String input = scanner.nextLine();
 
        while (!input.equals("JOKER")) {
            //input = "Peter: 2C, 4H, 9H, AS, QS" -> ["Peter", "2C, 4H, 9H, AS, QS"]
            String name = input.split(": ")[0]; //името на играча
            String cardsStr = input.split(": ")[1]; //"2C, 4H, 9H, AS, QS"
            String[] cardsArr = cardsStr.split(", "); //["2C", "4H", "9H", "AS", "QS"]
            Set<String> cards = new HashSet<>(); //изтеглените карти
            Collections.addAll(cards, cardsArr);
            //for (String card : cardsArr) {
            //cards.add(card);}
 
            //името го има
            if (playersCards.containsKey(name)) {
                //взимаме текушия сет от карти
                Set<String> currentCards = playersCards.get(name);
                //към текущия сет добавяме новия
                currentCards.addAll(cards);
                playersCards.put(name, currentCards);
            } else {
                //името да го няма
                playersCards.put(name, cards);
            }
            input = scanner.nextLine();
        }
 
        playersCards.entrySet().forEach(entry -> {
            //entry: име на играч -> списък с карти
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });
 
    }
 
    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> pointsMap = getPartOfCardValue();
        int sumCards = 0;
        //2C, 4H, 9H, AS, QS
        //всяка карта -> намирам точките -> добавям към сумата
        for (String card : cards) {
            int points = 0;
            //"[номер][тип]" -> "2C"    "10D"
            //номер: 2(2), 3(3), 4(4), 5(5), 6(6), 7(7), 8(8), 9(9), 10(10), J(11), Q(12), K(13), A(14)
            //тип: S(4), H(3), D(2), C(1)
            //точки за карта = точки от номер * точки от тип
            if (card.contains("10")) {
                //картата е 10 (card = "10C" -> номер = 10
                char type = card.charAt(2);
                points = 10 * pointsMap.get(type);
            } else {
                //всички карти без 10-ка
                //card = "2D"
                char number = card.charAt(0);
                char type = card.charAt(1);
                points = pointsMap.get(number) * pointsMap.get(type);
            }
            sumCards += points;
        }
        return sumCards;
    }
 
    //метод връща Map: номер / тип на картата -> брой точки
    private static Map<Character, Integer> getPartOfCardValue () {
        Map<Character, Integer> points = new HashMap<>();
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;
 
    }
 
 
}