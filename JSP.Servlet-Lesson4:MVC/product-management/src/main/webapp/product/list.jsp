<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 03/10/2023
  Time: 08:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<center>
    <head>
        <h1>Product management Application</h1>
    </head>
    <body>
    <h2><a href="/products?action=insert">Add new product</a></h2>
    <h2><a href="products?action=products">Show Product List</a></h2>
    <h2><a href="products?action=sort">Sort Products By Name</a></h2>

    <h2>Search product</h2>
    <form action="products" method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="productName" placeholder="Enter product name">
        <input type="submit" value="Search">
    </form>


    <table border=1>
        <caption><h2>List of products</h2></caption>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>price</td>
            <td>description</td>
            <td>actions</td>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}"></c:out></td>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td><c:out value="${product.description}"></c:out></td>
                <td>
                    <a href="/products?action=edit&id=${product.id}">edit</a>
                    <a href="/products?action=delete&id=${product.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </body>
</center>
</html>
