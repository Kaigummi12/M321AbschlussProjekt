package com.example.product_service.mapper;

import com.example.product_service.entity.ProductIN;
import com.example.product_service.entity.ProductOUT;
import com.example.product_service.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productInToProduct(ProductIN productIN);
    ProductOUT productToProductOut(Product product);
}
