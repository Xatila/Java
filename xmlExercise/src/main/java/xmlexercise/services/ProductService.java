package xmlexercise.services;

import xmlexercise.models.entitie.DTOs.ProductRootDTO;
import xmlexercise.models.entitie.DTOs.ProductSeedDto;

import java.util.List;

public interface ProductService {
    long getCountEntity();

    void seedProducts(List<ProductSeedDto> products);
}
