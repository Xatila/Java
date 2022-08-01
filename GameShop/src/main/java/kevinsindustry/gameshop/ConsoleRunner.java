package kevinsindustry.gameshop;

import kevinsindustry.gameshop.exceptions.ValidationException;
import kevinsindustry.gameshop.services.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ExecutorService executorService;

    @Autowired
    public ConsoleRunner(ExecutorService executeService) {
        this.executorService = executeService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        String result;
        try {
            result = executorService.execute(command);
        } catch (ValidationException ex) {
            result = ex.getMessage();
        }
        System.out.println(result);
    }
}
