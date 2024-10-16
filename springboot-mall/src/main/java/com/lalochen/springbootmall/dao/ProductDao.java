package com.lalochen.springbootmall.dao;

import com.lalochen.springbootmall.dto.ProductRequest;
import com.lalochen.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

}
