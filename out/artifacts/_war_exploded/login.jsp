<%--
  Created by IntelliJ IDEA.
  User: 张振东
  Date: 2020/4/12
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>留言板---登录界面</title>

    <style>
        .td_left{
            padding-top: 50px;
            width: 100px;
            text-align: right;
            height: 45px;
        }
        .td_right{
            /*    本身就是表格，就是内边距*/
            padding-left:50px ;
            padding-top: 50px;

        }
        #username,#password{
            width: 251px;
            height: 33px;
            border: 1px solid ;
            /*    边框圆角*/
            border-radius: 5px;
            padding-left: 10px;
        }
        .rg_layout {
            width: 1000px;
            height: 700px;
            background: white;
            border: 8px solid #EEEEEE;
            /*div居中*/
            margin: auto;
            margin-top: 20px;

        }

        .rg_left {

            float: left;
            margin-top: 15px;
        }

        .rg_center {
            margin-left: 200px;
            margin-top: 10px;
            /*border: 1px solid #FF0000;*/
            float: left;
            width: 450px;
        }

        .rg_right {
            margin: 15px;

            float: right;
        }
        *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }
        .rg_left >p:first-child{
            color: red;
            font-size: 20px;

        }
        .rg_left >p:last-child{
            color: #A6A6A6;
            font-size: 20px;

        }
        .rg_right p{
            font-size: 15px;
        }
        .rg_right p a{
            color: pink;
        }
        #btn_submit{
            width: 150px;
            height: 50px;
            margin-top: 50px;
            border:1px solid yellow;
            background-color: yellow;

        }
    </style>
    <script>
        var error='<%=request.getParameter("error")%>';
        if(error=='yes'){
            alert("登录失败");
        }
    </script>
</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>留言板用户登录</p>
        <p>USER LOGIN</p>
    </div>
    <div class="rg_center">
        <div class="rg_from">
            <form action="loginServlet" method="post">
                <table border="0">
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入账号名称"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码"></td>
                    </tr>

                    <tr>
                        <td align="center" colspan="2"><input type="submit" value="登录" id="btn_submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="rg_right">
        <p>还未注册？<a href="regist.jsp">赶快去注册</a></p></div>
</div>
<footer>
    <center>
        
        <font size=5px" color="#a9a9a9" face="楷体">©️1813004745张振东 </font><font color="red" size="5px"><a href="admin.jsp">管理后台</a></font>
    </center>
</footer>
</body>
</html>