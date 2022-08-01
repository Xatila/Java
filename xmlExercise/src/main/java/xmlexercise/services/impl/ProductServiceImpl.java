package xmlexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmlexercise.config.Validate;
import xmlexercise.models.entitie.DTOs.ProductSeedDto;
import xmlexercise.models.entitie.Product;
import xmlexercise.repositories.ProductRepo;
import xmlexercise.services.CategoryService;
import xmlexercise.services.ProductService;
import xmlexercise.services.UserService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
    private final Validate validate;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, Validate validate, UserService userService, CategoryService categoryService) {
        this.productRepo = productRepo;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = new ModelMapper();
        this.validate = validate;
    }

    @Override
    public long getCountEntity() {
        return productRepo.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products.stream().filter(validate::isValid)
                .map(productRootDTO ->{Product product = modelMapper.map(productRootDTO, Product.class);
                    product.setSeller(userService.getRandomUser());
                    if (product.getPrice().compareTo(BigDecimal.valueOf(700))>0){
                        product.setBuyer(userService.getRandomUser());
                    }
                    product.setCategories(categoryService.getRandomCategory());
                    return product;
                }).forEach(productRepo::save);
    }

}
