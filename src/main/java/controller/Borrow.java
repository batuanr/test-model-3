package controller;

import model.Book;
import model.Card;
import model.Student;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet(name = "Borrow", value = "/borrow")
public class Borrow extends HttpServlet {
    IBookService bookService = new BookService();
    IStudentService studentService = new StudentService();
    ICard cardService = new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showBorrow(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       borrow(request, response);
    }
    private void showBorrow(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void borrow(HttpServletRequest request, HttpServletResponse response){
        int bookId = Integer.parseInt(request.getParameter("id"));
        String studentCode = request.getParameter("student");
        Book book = bookService.findById(bookId);
        Student student = studentService.findByCode(studentCode);
        if (student == null){
            request.setAttribute("book", book);
            request.setAttribute("code", studentCode);
            request.setAttribute("mess", "code sai");
            RequestDispatcher dispatcher = request.getRequestDispatcher("borrow.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Date borrowDate = Date.valueOf(LocalDate.now());
        String date = request.getParameter("date");
        Date returnDate = Date.valueOf(date);
        if (borrowDate.after(returnDate)){
            request.setAttribute("book", book);
            request.setAttribute("code", student.getCode());
            request.setAttribute("mess", "return date sai");
            RequestDispatcher dispatcher = request.getRequestDispatcher("borrow.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Card card = new Card(book, student, borrowDate, returnDate, false);
            cardService.save(card);
            try {
                response.sendRedirect("/home");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
