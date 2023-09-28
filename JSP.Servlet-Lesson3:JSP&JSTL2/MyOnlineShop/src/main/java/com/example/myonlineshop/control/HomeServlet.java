package com.example.myonlineshop.control;

import com.example.myonlineshop.module.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home-servlet")
public class HomeServlet extends HttpServlet {
    private List<Product> productList;

    @Override
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Valhein", 99, "https://hthgaming.com/aov/wp-content/uploads/2020/12/valor-pass-chapter-23-rewards-thumbnail.jpg"));
        productList.add(new Product(2, "Kahlii", 199, "https://i.ytimg.com/vi/qyQDn9fjbUU/maxresdefault.jpg"));
        productList.add(new Product(3, "Toro", 99, "https://cdn.sforum.vn/sforum/wp-content/uploads/2022/02/272254995_434585608366918_7422411532363575596_n.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.setAttribute("productList", productList);
        resp.sendRedirect("showProducts.jsp");
    }
}
