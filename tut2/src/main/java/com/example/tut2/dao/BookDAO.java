package com.example.tut2.dao;

import com.example.tut2.dbconnect.DBConnect;
import com.example.tut2.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    Connection connection;

    public BookDAO() {
        connection = DBConnect.getConnection();
    }

    public List<Book> selectAllBooks() {
        List<Book> bookList = new ArrayList<>();

        String SQL = "SELECT * FROM book";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");

                Book book = new Book(id, title, author, price);

                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    /**
     * @param book
     * @implSpec Insert Book to Database
     */
    public boolean addBook(Book book) {

        boolean rowInserted = false;
        String sql = "INSERT INTO book(title, author, price) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setFloat(3, book.getPrice());
            rowInserted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("Error Add book " + rowInserted);
        return rowInserted;
    }

    /**
     * @param book
     * @implSpec Edit Book
     */
    public boolean updateBook(Book book) {

        boolean rowUpdated = false;
        String SQL = "UPDATE book SET title = ?, author = ?, price = ?";
        SQL += " WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setFloat(3, book.getPrice());
            preparedStatement.setInt(4, book.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    /**
     * @param book
     * @implSpec Delete Book
     */
    public boolean deleteBook(Book book) {
        String SQL = "DELETE FROM book where id = ?";

        PreparedStatement preparedStatement = null;
        boolean rowDeleted = false;
        try {
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, book.getId());

            rowDeleted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    /**
     * @param id
     * @implSpec Get Book
     */
    public Book getBook(int id) {
        Book book = null;
        String sql = "SELECT * FROM book WHERE id = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");

                book = new Book(id, title, author, price);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
