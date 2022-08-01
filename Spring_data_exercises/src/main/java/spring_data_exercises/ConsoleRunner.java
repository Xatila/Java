package spring_data_exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_data_exercises.services.SeedService;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;

    @Autowired
    public ConsoleRunner(SeedService seedService) {
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("starting...");

        this.seedService.seedAuthor();
    }
}
