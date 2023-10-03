package com.example.productmanagement.controller;


import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="productServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private static final long SERIAL_VERSION_UID=1L;
    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null){
            action = "";
        }

        try{
            switch (action){
                case "insert":
                    insertProduct(req,resp);
                    break;
                case "edit":
                    editProduct(req,resp);
                    break;
                default:
                    break;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        if (action == null){
            action = "";
        }

        try{
            switch (action){
                case"sort":
                    sortProductsByName(req,resp);
                    break;
                case "search":
                    searchProduct(req,resp);
                    break;
                case "insert":
                    showInsertForm(req,resp);
                    break;
                case "delete":
                    deleteProduct(req,resp);
                    break;
                case "edit":
                    showEditForm(req,resp);
                    break;
                default:
                    showProductList(req,resp);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sortProductsByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> listProduct = productDAO.sortProductsByName();
        req.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input_name = req.getParameter("productName");
        System.out.println(input_name);
        List<Product> listProduct = productDAO.searchProduct(input_name);
        req.setAttribute("listProduct",listProduct);

        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> listProduct = productDAO.showAllProducts();
        req.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showInsertForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/insert.jsp");
        dispatcher.forward(req,resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        productDAO.deleteProduct(id);

        List<Product> listProduct = productDAO.showAllProducts();
        req.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        req.setAttribute("product",product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(req,resp);
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");

        Product product = new Product(name, price, description);
        productDAO.insertProduct(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/insert.jsp");
        dispatcher.forward(req,resp);
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");

        Product product = new Product(name, price, description);
        productDAO.editProduct(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(req,resp);
    }
}
