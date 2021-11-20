package service;

import connection.ConnectionSingleton;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{
    public static final String SELECT_FROM_BOOK = "select * from Book";
    public static final String SELECT_FROM_BOOK_WHERE_ID = "select * from Book where id = ?";
    public static final String SELECT_FROM_BOOK_WHERE_NAME = "select * from Book where name = ?";
    Connection connection = ConnectionSingleton.getConnection();
    @Override
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_BOOK);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String code = resultSet.getString("code");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(id, name, code, quantity);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_BOOK_WHERE_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String code = resultSet.getString("code");
                int quantity = resultSet.getInt("quantity");
                book = new Book(id, name, code, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> findByName(String name) {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_BOOK_WHERE_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(id, name, code, quantity);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
