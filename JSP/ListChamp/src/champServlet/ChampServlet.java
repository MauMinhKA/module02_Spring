package champServlet;

import champ.ChampsList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChampServlet",urlPatterns = "/champs")
public class ChampServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("champList", ChampsList.getChamp());
        RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/champ/champs.jsp");
        requestDispatcher.forward(request, response);
    }
}
