package controller;

import model.Card;
import service.CardService;
import service.ICard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CardServlet", value = "/card")
public class CardServlet extends HttpServlet {
    ICard cardService = new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showList(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showList(request, response);
    }
    private void showList(HttpServletRequest request, HttpServletResponse response){
        List<Card> cardList = cardService.getAllCardFalse();
        request.setAttribute("list", cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cardList.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
