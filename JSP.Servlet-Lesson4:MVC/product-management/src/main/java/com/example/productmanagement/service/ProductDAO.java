package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private String jdbc_url = "jdbc:mysql://localhost:3306/demo?useSSl=false";
    private String jdbc_username = "root";
    private String jdbc_password = "1";

    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> showAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "{CALL show_all_products}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                products.add(new Product(id, name, price, description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        String query = "{CALL insert_product(?,?,?,?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, product.getId());
            callableStatement.setString(2, product.getName());
            callableStatement.setDouble(3, product.getPrice());
            callableStatement.setString(4, product.getDescription());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean productDeleted;
        String query = "{CALL delete_product(?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            productDeleted = callableStatement.executeUpdate() > 0;
        }
        return productDeleted;
    }

    @Override
    public boolean editProduct(Product product) throws SQLException {
        boolean productEdited;
        String query = "{CALL edit_product(?,?,?,?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, product.getId());
            callableStatement.setString(2, product.getName());
            callableStatement.setDouble(3, product.getPrice());
            callableStatement.setString(4, product.getDescription());
            productEdited = callableStatement.executeUpdate() > 0;
        }
        return productEdited;
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        String query = "{CALL search_product_by_id(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, id);

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int p_id = resultSet.getInt("id");
                String p_name = resultSet.getString("name");
                double p_price = resultSet.getDouble("price");
                String p_description = resultSet.getString("description");
                product = new Product(p_id, p_name, p_price, p_description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> searchProduct(String input_name) {
        List<Product> productList = new ArrayList<>();
        String query = "{call search_product(?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, input_name);

            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");

                Product product = new Product(id, name, price, description);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> sortProductsByName() {
        List<Product> productList = new ArrayList<>();
        String query = "{CALL sort_products_by_name()}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");

                Product product = new Product(id, name, price, description);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
