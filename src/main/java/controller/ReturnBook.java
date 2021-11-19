package controller;

import model.Book;
import model.Card;
import service.BookService;
import service.CardService;
import service.IBookService;
import service.ICard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReturnBook", value = "/return")
public class ReturnBook extends HttpServlet {
    IBookService bookService = new BookService();
    ICard cardService = new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        returnBook(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public  void returnBook(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Card card = cardService.findById(id);
        cardService.edit(card);
        try {
            response.sendRedirect("/card");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
