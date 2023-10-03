<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 03/10/2023
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<center>
    <head>
        <title>Product management Application</title>
    </head>
    <body>
    <h2><a href="products?action=products">Show Product List</a></h2>
    <form method="post">
        <table border="1">
            <caption><h2>Edit Product</h2></caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value ='${product.id}'/>"/>
            </c:if>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Description:</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${product.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
    </body>
</center>
</html>
