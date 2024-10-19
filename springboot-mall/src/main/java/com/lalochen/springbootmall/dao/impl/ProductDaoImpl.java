package com.lalochen.springbootmall.dao.impl;

import com.lalochen.springbootmall.constant.ProductCategory;
import com.lalochen.springbootmall.dao.ProductDao;
import com.lalochen.springbootmall.dto.ProductRequest;
import com.lalochen.springbootmall.model.Product;
import com.lalochen.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getProducts(ProductCategory category, String search) {

        String sql = "select product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date" +
                " from product  WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        if (category != null) {
            sql = sql  + " AND category = :category";
            map.put("category", category.name());
        }

        if (search != null) {
            sql = sql  + " AND product_name LIKE :search";
            map.put("search", "%" + search + "%");
        }

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "select product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date from product where product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (!productList.isEmpty()) {
            return productList.getFirst();
        }else{
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
       String sql = "INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date)\n" +
               "VALUES (:productName, :category, :imageUrl, :price, :stock, :description, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        LocalDateTime now = LocalDateTime.now();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int productId = keyHolder.getKey().intValue();
        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName, category = :category, image_url= :imageUrl, price = :price, stock = :stock, description = :description, last_modified_date = :lastModifiedDate WHERE product_id = :productId;\n";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("lastModifiedDate", new Date());
        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);

    }
}
