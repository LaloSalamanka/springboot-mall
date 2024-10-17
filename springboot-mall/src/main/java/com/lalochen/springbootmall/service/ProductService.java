package com.lalochen.springbootmall.service;

import com.lalochen.springbootmall.dto.ProductRequest;
import com.lalochen.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
