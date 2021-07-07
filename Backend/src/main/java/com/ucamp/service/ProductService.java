package com.ucamp.service;

import java.util.List;

import com.ucamp.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> search(String query);
}
