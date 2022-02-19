package com.example.tut2.servlet;

import com.example.tut2.dao.BookDAO;
import com.example.tut2.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/")
public class ServletBook extends HttpServlet {
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        System.out.println("Action " + action);

        switch (action) {
            case "/new":
                showAddForm(request, response);
                break;
            case "/insert":
                addBook(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/delete":
                deleteBook(request, response);
                break;
            case "/update":
                updateBook(request, response);
                break;
            default:
                getBookList(request, response);
                break;
        }
    }

    public void getBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> listBook = bookDAO.selectAllBooks();
        System.out.println("List Book " + listBook.get(0).getId());
        request.setAttribute("books", listBook);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("booklist.jsp");
        requestDispatcher.forward(request, response);
    }

    public void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addbook.jsp");
        dispatcher.forward(request, response);
    }

    public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");

        System.out.println("Title " + title + " Author " + author);
        float price = Float.parseFloat(request.getParameter("price"));
        Book book = new Book(title, author, price);
        bookDAO.addBook(book);
        response.sendRedirect("list");
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.getBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editbook.jsp");
        request.setAttribute("book", book);
        dispatcher.forward(request, response);
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = new Book(id);
        bookDAO.deleteBook(book);
        response.sendRedirect("list");
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));
        Book book = new Book(id, title, author,price);
        bookDAO.updateBook(book);
        response.sendRedirect("list");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("ACTION");
    }
}
