package productshopApp.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshopApp.entities.categories.Category;
import productshopApp.entities.products.Product;
import productshopApp.entities.categories.CategoryImportDTO;
import productshopApp.entities.products.ProductImportDTO;
import productshopApp.entities.users.User;
import productshopApp.entities.users.UserImportDTO;
import productshopApp.repositories.CategoryRepository;
import productshopApp.repositories.ProductRepository;
import productshopApp.repositories.UserRepository;
import productshopApp.services.SeedService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private static final String USERS_JSON_FILE = "src/main/resources/files/users.json";
    private static final String CATEGORY_JSON_FILE = "src/main/resources/files/categories.json";
    private static final String PRODUCTS_JSON_FILE = "src/main/resources/files/products.json";


    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void seedUser() throws FileNotFoundException {
        FileReader fileReader = new FileReader(USERS_JSON_FILE);
        UserImportDTO[] userImportDTOS = this.gson.fromJson(fileReader, UserImportDTO[].class);
       List<User> users = Arrays.stream(userImportDTOS).map(importDTO-> this.modelMapper.map(importDTO, User.class)).collect(Collectors.toList());
       userRepository.saveAll(users);
    }

    @Override
    public void seedCategory() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CATEGORY_JSON_FILE);
        CategoryImportDTO[] categotyImportDTO = this.gson.fromJson(fileReader, CategoryImportDTO[].class);
        List<Category> categories = Arrays.stream(categotyImportDTO).map(importDTO-> this.modelMapper.map(importDTO, Category.class)).collect(Collectors.toList());
        categoryRepository.saveAll(categories);
    }

    @Override
    public void seedProduct() throws FileNotFoundException {
        FileReader fileReader = new FileReader(PRODUCTS_JSON_FILE);
        ProductImportDTO[] productImportDTOS = this.gson.fromJson(fileReader, ProductImportDTO[].class);
        List<Product> products = Arrays.stream(productImportDTOS).map(importDTO-> this.modelMapper.map(importDTO, Product.class)).collect(Collectors.toList());
        productRepository.saveAll(products);
    }

}
