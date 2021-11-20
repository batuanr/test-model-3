package model;

import java.time.LocalDate;
import java.util.Date;

public class Card {
    private int id;
    private Book book;
    private Student student;
    private Date borrowedDate;
    private Date returnDate;
    private boolean status;

    public Card(int id, Book book, Student student, Date borrowedDate, Date returnDate, boolean status) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Card(Book book, Student student, Date borrowedDate, Date returnDate, boolean status) {
        this.book = book;
        this.student = student;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Card(Book book, Student student, Date borrowedDate, boolean status) {
        this.book = book;
        this.student = student;
        this.borrowedDate = borrowedDate;
        this.status = status;
    }

    public Card(int id, Book book, Student student, Date borrowedDate, Date returnDate) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
