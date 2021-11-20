package controller;

import service.CardService;
import service.ICard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCard", value = "/deleteCard")
public class DeleteCard extends HttpServlet {
    ICard cardService = new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        delete(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void delete(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        cardService.delete(id);
        try {
            response.sendRedirect("/cardTrue");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
