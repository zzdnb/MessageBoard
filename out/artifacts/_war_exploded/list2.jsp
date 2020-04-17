<%--
  Created by IntelliJ IDEA.
  User: 张振东
  Date: 2020/4/13
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>管理员系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteNews(id) {
            if (confirm("确定删除吗")) {
                location.href = "delNewsServlet?id=" + id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">留言板列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>内容</th>

        </tr>
        <c:forEach items="${news}" var="ly" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${ly.username}</td>
                <td>${ly.content}</td>
                <td><a class="btn btn-default btn-sm" href="javascript:deleteNews(${ly.id}) ">删除</a></td>

            </tr>
        </c:forEach>


    </table>
</div>
</body>
</html>

