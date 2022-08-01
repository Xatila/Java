package xmlexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xmlexercise.config.XmlParser;
import xmlexercise.models.entitie.DTOs.CategoryRootSeedDTO;
import xmlexercise.models.entitie.DTOs.ProductRootDTO;
import xmlexercise.models.entitie.DTOs.UserRootSeedDTO;
import xmlexercise.services.CategoryService;
import xmlexercise.services.ProductService;
import xmlexercise.services.UserService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final XmlParser xmlParser;
    private static final String PATH_TO_CATEGORIES = "src/main/resources/files/categories.xml";
    private static final String PATH_TO_USERS = "src/main/resources/files/users.xml";
    private static final String PATH_TO_PRODUCTS = "src/main/resources/files/products.xml";

    @Autowired
    public ConsoleRunner(CategoryService categoryService, UserService userService, ProductService productService, XmlParser xmlParser) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();

    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getCountEntity()==0) {
            CategoryRootSeedDTO categoryRootSeedDTO = xmlParser.fromFile(PATH_TO_CATEGORIES, CategoryRootSeedDTO.class);
            this.categoryService.seedCategories(categoryRootSeedDTO.getCategories());
        }

        if (userService.getCountEntity()==0){
            UserRootSeedDTO userRootSeedDTO = xmlParser.fromFile(PATH_TO_USERS, UserRootSeedDTO.class);
            this.userService.seedUsers(userRootSeedDTO.getUsers());

        }
        if(productService.getCountEntity()==0){
            ProductRootDTO productRootDTO = xmlParser.fromFile(PATH_TO_PRODUCTS, ProductRootDTO.class);
            this.productService.seedProducts(productRootDTO.getProducts());
        }



    }
}
