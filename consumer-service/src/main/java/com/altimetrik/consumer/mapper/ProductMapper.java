package com.altimetrik.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.altimetrik.consumer.entity.ProductEntity;
import com.altimetrik.shared.dto.Product;

@Mapper
public interface ProductMapper {

	ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

	ProductEntity mapToProductEntity(Product priceDto);

}
