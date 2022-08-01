package productshopApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import productshopApp.entities.categories.CategoryXMLDTO;
import productshopApp.services.SeedService;

import javax.xml.bind.JAXBContext;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;

    @Autowired
    public ConsoleRunner(SeedService seedService1) {
        this.seedService = seedService1;
    }

    @Override
    public void run(String... args) throws Exception {

        JAXBContext context = JAXBContext.newInstance(CategoryXMLDTO.class);
        context.createMarshaller().marshal();

    }
}
