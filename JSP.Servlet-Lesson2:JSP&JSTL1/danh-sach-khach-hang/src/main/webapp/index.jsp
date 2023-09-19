<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>
<div class="all">
    <h1>Danh sách khách hàng</h1>
    <table border="1" >
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birthdate}</td>
                <td>${customer.address}</td>
                <td><img src="${customer.imagePath}" alt="Ảnh khách hàng" width="100" height="100"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>