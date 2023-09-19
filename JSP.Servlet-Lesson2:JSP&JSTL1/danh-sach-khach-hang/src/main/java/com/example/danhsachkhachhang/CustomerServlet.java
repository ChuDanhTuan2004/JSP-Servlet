package com.example.danhsachkhachhang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", value = "")
public class CustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("CD Tuấn", "01/01/2000", "Hà Nội", "img/tuancd.jpg"));
        customerList.add(new Customer("Chu Tuấn", "15/05/2004", "Hà Tây", "img/tuancd.jpg"));

        // Thêm các khách hàng khác vào danh sách
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
