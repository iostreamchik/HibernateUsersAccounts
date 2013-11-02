<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/login.css">
<%--<jsp:useBean id="autentification" class="logic.Login"/>--%>
<%--<%String m = <jsp:getProperty name="autentification" property="loginStatus"/> %>--%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p>
    Today's date: <%= (new java.util.Date()).toLocaleString()%>
</p>
<h2>Please sign in</h2>

<form action="Login" method="post">
    <table id="sign_in">
        <tr>
            <td>
                Login:
            </td>
            <td>
                <input class="input" type="text" name="login"/>
            </td>
            <td>
                <input class="input" type="submit" value="Login"/>
            </td>
        </tr>
        <tr>
            <td>
                Password:
            </td>
            <td>
                <input type="password" name="pass"/>
            </td>
            <td>
                <input class="input" type="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form>
<%--<jsp:include page="/Login"/>--%>
</body>
</html>