<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");
    String search = request.getParameter("search");
    String result = dic.get(search);
    PrintWriter printWriter = response.getWriter(); // Đổi tên biến thành printWriter
    if (result != null) {
        printWriter.println("Word: " + search + "<br>");
        printWriter.println("Result: " + result + "<br>");
    } else {
        printWriter.println("Not found");
    }
%>
</body>
</html>