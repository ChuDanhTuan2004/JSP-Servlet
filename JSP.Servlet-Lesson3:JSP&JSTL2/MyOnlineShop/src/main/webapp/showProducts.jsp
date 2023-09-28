<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 25/09/2023
  Time: 09:52
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

        /* Navigation menu */
        nav {
            background-color: lightblue;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        nav li {
            float: left;
        }

        nav li a {
            display: block;
            color: darkblue;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Products section */
        section.products {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-evenly;
            padding: 30px;
        }

        .product {
            border: 1px solid rgb(128, 128, 128);
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
<header><h1>My Online Shop</h1></header>
<!-- Navigation Menu -->
<nav>
    <ul>
        <li><a href="showCart.jsp">Show cart</a></li>
    </ul>
</nav>
<!-- Products Section -->
<section class="products">
    <c:forEach items="${productList}" var="product">
        <form action="/cart-servlet" method="post">
            <div class="product">
                <img src="${product.image}" >
                <input type="hidden" name="image" value="${product.getImage()}">
                <h3>${product.id}</h3>
                <input type="hidden" name="id" value="${product.getId()}">
                <h3>${product.name}</h3>
                <input type="hidden" name="name" value="${product.getName()}">
                <p>${product.price}</p>
                <input type="hidden" name="price" value="${product.getPrice()}">
                <input type="submit" value="Add to cart">
            </div>
        </form>
    </c:forEach>
</section>
<!-- Footer -->
<footer><p>Copyright &copy; 2023 - My Online Shop</p></footer>
</body>
</html>
