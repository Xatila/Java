package productshopApp.services;

import java.io.FileNotFoundException;

public interface SeedService {

    void seedUser() throws FileNotFoundException;
    void seedProduct() throws FileNotFoundException;
    void seedCategory() throws FileNotFoundException;

    default void seedData() throws FileNotFoundException {
        seedUser();
        seedProduct();
        seedCategory();
    }
}
