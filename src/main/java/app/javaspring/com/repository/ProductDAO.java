package app.javaspring.com.repository;

import app.javaspring.com.models.Product;

import java.util.List;

public interface ProductDAO {
    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
