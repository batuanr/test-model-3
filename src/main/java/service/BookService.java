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
    Connection connection = ConnectionSingleton.getConnection();
    @Override
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Book");
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
            PreparedStatement statement = connection.prepareStatement("select * from Book where id = ?");
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
}
