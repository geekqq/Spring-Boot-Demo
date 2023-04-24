package com.geekkk.springdemo.service;

import com.geekkk.springdemo.error.ProductNotFoundException;
import com.geekkk.springdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    List<Product> productList = new ArrayList<>();
    @Override
    public Product save(Product product) {
        if (product.getProductId() == null) {
            product.setProductId(UUID.randomUUID().toString());
        }
        productList.add(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getById(String id) {
        return productList.stream().filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public String deleteById(String id) {
        Product product =  productList.stream().filter(p -> p.getProductId().equals(id)).findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
        productList.remove(product);
        return "Product with id{id} has been removed!";
    }

    @Override
    public void updateById(String id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            if (p.getProductId().equals(id)) {
                productList.set(i, product);
                return;
            }
        }
    }

}
