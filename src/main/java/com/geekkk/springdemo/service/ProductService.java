package com.geekkk.springdemo.service;

import com.geekkk.springdemo.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> getAll();

    Product getById(String id);

    String deleteById(String id);

    void updateById(String id, Product product);
}
