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
    public static final String INSERT_CARD = "insert into Card (bookid, StudentID, borroweddate, returndate) value (?, ?, ?, ?)";
    public static final String SELECT_FROM_CARD_WHERE_ID = "select * from Card where id = ?";
    public static final String SELECT_FROM_CARD = "select * from Card";
    public static final String RETURN_CARD = "update Card set status = true , returndate = ? where id = ?";
    public static final String DELETE_FROM_CARD_WHERE_ID = "delete from Card where id = ?";
    public static final String SELECT_FROM_CARD_WHERE_STATUS_TRUE = "select * from Card where status = true";
    public static final String SELECT_FROM_CARD_WHERE_STATUS_FALSE = "select * from Card where status = false";
    Connection connection = ConnectionSingleton.getConnection();
    IStudentService studentService = new StudentService();
    IBookService bookService = new BookService();
    @Override
    public List<Card> getAll() {
        List<Card> cardList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_CARD);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);
                boolean status = resultSet.getBoolean("status");
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                Card card = new Card(id, book, student, borroweddate, returndate, status);
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
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_CARD_WHERE_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);
                boolean status = resultSet.getBoolean("status");
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                card = new Card(id, book, student, borroweddate, returndate, status);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public void save(Card card) {
        try {
        PreparedStatement statement = connection.prepareStatement(INSERT_CARD);
        statement.setInt(1, card.getBook().getId());
        statement.setInt(2, card.getStudent().getId());
        Date date = java.sql.Date.valueOf(LocalDate.now());
        statement.setDate(3, (java.sql.Date) date);
        statement.setDate(4, (java.sql.Date) card.getReturnDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Card card) {
        try {
            PreparedStatement statement = connection.prepareStatement(RETURN_CARD);
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
            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_CARD_WHERE_ID);
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
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_CARD_WHERE_STATUS_TRUE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);
                boolean status = resultSet.getBoolean("status");
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                Card card = new Card(id, book, student, borroweddate, returndate, status);
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
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_CARD_WHERE_STATUS_FALSE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int bookID = resultSet.getInt("bookid");
                int studentId = resultSet.getInt("StudentID");
                Book book = bookService.findById(bookID);
                Student student = studentService.findById(studentId);;
                Date borroweddate = resultSet.getDate("borroweddate");
                Date returndate = resultSet.getDate("returndate");
                Card card = new Card(id, book, student, borroweddate, returndate);
                cardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }
}
