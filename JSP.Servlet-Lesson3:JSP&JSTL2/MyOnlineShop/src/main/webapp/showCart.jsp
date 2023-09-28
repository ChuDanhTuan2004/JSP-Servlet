<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 25/09/2023
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        /* Style for Header */
        header {
            background-color: darkblue;
            color: white;
            padding: 20px;
        }

        /* Products section */
        section.products {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-evenly;
            padding: 30px;
        }

        .product {
            border: 1px solid gray;
            width: 300px;
            margin-bottom: 20px;
            text-align: center;
        }

        .product img {
            width: 100%;
        }

        /* Footer */
        footer {
            background-color: darkblue;
            color: white;
            padding: 20px;
            text-align: center;
        }

        /* Responsive layout for smaller screens */
        @media screen and (max-width: 600px) {
            nav ul li {
                float: none;
                display: block;
            }
        }
    </style>
</head>
<body>
<!-- Header -->
<header><h1>Customer's Cart</h1></header>
<!-- Products Section -->
<section class="products">
    <form action="/buy-servlet" method="post">
    <c:forEach items="${addedProductList}" var="product">
            <div class="product">
                <img src="${product.getImage()}">
                <h3>${product.getId()}</h3>
                <h3>${product.getName()}</h3>
                <p>${product.getPrice()}</p>
                <input type="submit" value="Buy">
            </div>
    </c:forEach>
    </form>
</section>
<!-- Footer -->
<footer><p>Copyright &copy; 2023 - My Online Shop</p></footer>
</body>
</html>
