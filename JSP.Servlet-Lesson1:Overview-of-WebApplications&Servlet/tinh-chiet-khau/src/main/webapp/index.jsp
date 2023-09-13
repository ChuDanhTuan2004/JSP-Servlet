<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>Tinh chiet khau</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Vui long nhap thong tin</h2>
<form action="/tinhchietkhau" method="post">
    <input type="text" name="motasp" placeholder="Mo ta san pham: "/>
    <br>
    <input type="text" name="giagocsp" placeholder="Gia goc san pham: "/>
    <br>
    <input type="text" name="chietkhausp" placeholder="Chiet khau %: "/>
    <br>
    <input type = "submit" id = "submit" value = "Tinh toan"/>
</form>
</body>
</html>