package com.rpe.products.mapper;

import com.rpe.products.domain.Product;
import com.rpe.products.domain.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequest source);

}
