package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> showAllProducts();
    void insertProduct(Product product) throws SQLException;
    boolean deleteProduct(int id) throws SQLException;
    boolean editProduct(Product product) throws SQLException;
    Product selectProduct(int id);
    List<Product> searchProduct(String input_name);

    //sort_products_by_name
    List<Product> sortProductsByName();
}
