package com.lalochen.springbootmall.dao;

import com.lalochen.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
