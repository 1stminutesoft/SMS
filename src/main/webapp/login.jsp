<%-- 
    Document   : login
    Created on : 18 May 2025, 10:55:12 AM
    Author     : fakhr
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login - Student Management System</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>

        <jsp:include page="navbar.jsp" />

        <div class="container mt-5">
            <h2>Login</h2>

            <% if (request.getAttribute("error") != null) {%>
            <div class="alert alert-danger">
                <%= request.getAttribute("error")%>
            </div>
            <% }%>

            <form action="LoginServlet" method="post" class="mt-3">
                <div class="form-group">
                    <label>Email address</label>
                    <input type="email" name="email" required class="form-control" />
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" required class="form-control" />
                </div>

                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>

    </body>
</html>

