<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/02/2022
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Management</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<div class="view"
        style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/Others/img%20%2848%29.webp'); background-repeat: no-repeat; background-size: cover; background-position: center center;"
>
    <nav class="navbar navbar-light bg-dark justify-content-center">
        <span class="navbar-brand mb-0 h1 text-white">Book List</span>
    </nav>

    <div class="container col-md-6 mt-3">
        <ul class="nav justify-content-center mx-auto mt-3">
            <a type="button" class="btn btn-dark me-2 " href="new">Add New Book</a>

            <a type="button" class="btn btn-dark" href="list">List All Book</a>
        </ul>


        <table class="table table-bordered text-center mt-3">
            <tr>
                <th style="color:white">Book ID</th>
                <th style="color:white">Book Title</th>
                <th style="color:white">Book Author</th>
                <th style="color:white">Book Price</th>
                <th style="color:white">Menu</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td style="color:white"><c:out value="${book.id}"/></td>
                    <td style="color:white"><c:out value="${book.title}"/></td>
                    <td style="color:white"><c:out value="${book.author}"/></td>
                    <td style="color:white"><c:out value="${book.price}"/></td>
                    <td>
                        <a type="button" class="btn btn-outline-warning"
                           href="edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a type="button" class="btn btn-outline-danger"
                           href="delete?id=<c:out value='${book.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
