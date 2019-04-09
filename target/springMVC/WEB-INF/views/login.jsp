<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/11/22
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
</head>
<body>


    <form action="login" name="loginForm">
        用户名:<input type="text" name="username" id="username" /><br/>
        密&nbsp;码:<input type="text" name="password" id="password" ><br/>
        <button type="button" name="submit" id="submit" onclick="doLogin()"><span>登录</span></button>
    </form>

<script type="text/javascript">
    function doLogin(){

        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: "POST",
            url: "login",
            data: "username="+username+"&password=" + password,
            success: function(resp){
                if(resp.success){
                    location.href = "logout";
                }else{
                    location.href = "error";
                }
            }
        });
    }

</script>
</body>
</html>
