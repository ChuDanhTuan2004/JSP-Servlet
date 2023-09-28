package com.example.myonlineshop.control;

import com.example.myonlineshop.module.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartServlet", value = "/cart-servlet")
public class CartServlet extends HttpServlet {
    private static ArrayList<Product> addedProductList;

    @Override
    public void init() throws ServletException {
        addedProductList = new ArrayList<>();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        System.out.println(id+name+price);

        addedProductList.add(new Product(id, name, price, image));
        HttpSession session = req.getSession();
        session.setAttribute("addedProductList", addedProductList);
        req.getRequestDispatcher("showCart.jsp").forward(req, resp);

    }
}
