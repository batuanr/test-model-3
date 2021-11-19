package controller;

import model.Book;
import service.BookService;
import service.IBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeLibrary", value = "/home")
public class homeLibrary extends HttpServlet {
    IBookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showListBook(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showListBook(request, response);
    }
    private void showListBook(HttpServletRequest request, HttpServletResponse response){
        List<Book> bookList = bookService.getAll();
        request.setAttribute("list", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
