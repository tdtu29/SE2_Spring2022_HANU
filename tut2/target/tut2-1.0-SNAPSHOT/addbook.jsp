<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/02/2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Management</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-dark justify-content-center">
    <span class="navbar-brand mb-0 h1 text-white">Book List</span>
</nav>


<!-- Background image -->
<div class="bg-image d-flex justify-content-center align-items-center"
     style="
    background-image: url('https://mdbcdn.b-cdn.net/img/new/fluid/nature/015.webp');
    height: 100vh;
  "
>
    <div class="container col-md-8 ">
        <%--    <h2 class="p-3 mb-2 bg-dark text-white text-center" >Friend List</h2>--%>

        <ul class="nav justify-content-center">
            <a type="button" class="btn btn-dark me-5 " href="new">Add New Book</a>

            <a type="button" class="btn btn-dark " href="list">List All Book</a>
        </ul>

        <div align="center">
            <form action="insert" method="GET">
                <h2 class="m-4">
                    <div class="text-light">
                        Add New Book
                    </div>
                </h2>

                <table class="table table-dark table-hover table-striped text-center mt-3">
                    <caption>
                    </caption>
                    <tr>
                        <th>Title:</th>
                        <td>
                            <input class="shadow bg-body rounded" type="text" name="title" size="45"
                                   value='${book.title}'/>
                        </td>
                    </tr>

                    <tr>
                        <th>Author:</th>
                        <td>
                            <input class="shadow bg-body rounded" type="text" name="author" size="45"
                                   value='${book.author}'/>
                        </td>
                    </tr>

                    <tr>
                        <th>Price:</th>
                        <td>
                            <input class="shadow bg-body rounded" type="text" name="price" size="45"
                                   value='${book.price}'/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center">
                            <div>
                                <input type="submit" value="Save" class="btn btn-dark"/>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="toast">
            <div class="toast-header">
                <strong class="me-auto">Toast Header</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
            </div>
            <div class="toast-body">
                <p>Some text inside the toast body</p>
            </div>
        </div>
    </div>

    <script>
        document.getElementById("toastbtn").onclick = function () {
            var toastElList = [].slice.call(document.querySelectorAll('.toast'))
            var toastList = toastElList.map(function (toastEl) {
                return new bootstrap.Toast(toastEl)
            })
            toastList.forEach(toast => toast.show())
        }
    </script>
</div>

</div>
</body>
</html>
