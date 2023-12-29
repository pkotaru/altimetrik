package com.altimetrik.consumer.mapper;

import com.altimetrik.consumer.entity.ProductEntity;
import com.altimetrik.shared.dto.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-28T21:44:52+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity mapToProductEntity(Product priceDto) {
        if ( priceDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( priceDto.getId() );
        productEntity.setName( priceDto.getName() );
        productEntity.setPrice( priceDto.getPrice() );

        return productEntity;
    }
}
