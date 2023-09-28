<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 25/09/2023
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <li><a href="/home-servlet">Products</a></li>
    </ul>
</nav>
<!-- Footer -->
<footer><p>Copyright &copy; 2023 - My Online Shop</p></footer>
</body>
</html>
