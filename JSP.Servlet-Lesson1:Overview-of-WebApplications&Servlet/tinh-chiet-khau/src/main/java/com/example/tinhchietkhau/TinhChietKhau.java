package com.example.tinhchietkhau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TinhChietKhauServlet", urlPatterns = "/tinhchietkhau")
public class TinhChietKhau extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenSP = request.getParameter("motasp");
        float giaSP = Float.parseFloat(request.getParameter("giagocsp"));
        float chietkhauSP = Float.parseFloat(request.getParameter("chietkhausp"));

        float giaChietKhau = giaSP - (giaSP * chietkhauSP / 100);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Ten san pham:" +tenSP+ "</h1>");
        writer.println("<h1>Gia goc:" +giaSP+ "</h1>");
        writer.println("<h1>Chiet khau: " + chietkhauSP + "</h1>");
        writer.println("<h1>Gia sau chiet khau: " + giaChietKhau + "</h1>");
        writer.println("</html>");
    }
}
