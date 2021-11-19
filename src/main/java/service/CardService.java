package service;

import connection.ConnectionSingleton;
import model.Book;
import model.Card;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardService implements ICard{
    Connection connection = ConnectionSingleton.getConnection();
    IStudentService studentService = new StudentService();
    IBookService bookService = new BookService();
    @Override
    public List<Card> getAll() {
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Card");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);
                boolean status = resultSet.getBoolean("status");
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                Card card = new Card(id, book, code, student, borroweddate, returndate, status);
                cardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    @Override
    public Card findById(int id) {
        Card card = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Card where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString("code");
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);
                boolean status = resultSet.getBoolean("status");
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                card = new Card(id, book, code, student, borroweddate, returndate, status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public void save(Card card) {
        try {
        PreparedStatement statement = connection.prepareStatement("insert into Card (code, bookid, StudentID, status, borroweddate, returndate) value (?, ?, ?, ?, ?, ?)");
        statement.setString(1, card.getCode());
        statement.setInt(2, card.getBook().getId());
        statement.setInt(3, card.getStudent().getId());
        statement.setBoolean(4, false);
        Date date = java.sql.Date.valueOf(LocalDate.now());
        statement.setDate(5, (java.sql.Date) date);
        statement.setDate(6, (java.sql.Date) card.getReturnDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Card card) {
        try {
            PreparedStatement statement = connection.prepareStatement("update Card set status = true , returndate = ? where id = ?");
            statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            statement.setInt(2, card.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from Card where StudentID = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Card> getCardTrue() {
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Card where status = true ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);
                boolean status = resultSet.getBoolean("status");
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                Card card = new Card(id, book, code, student, borroweddate, returndate, status);
                cardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    @Override
    public List<Card> getAllCardFalse() {
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from Card where status = false ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);
                boolean status = resultSet.getBoolean("status");
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                Card card = new Card(id, book, code, student, borroweddate, returndate, status);
                cardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }
}
