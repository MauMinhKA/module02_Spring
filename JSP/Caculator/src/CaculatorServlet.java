import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CaculatorServlet", urlPatterns = "/caculator")
public class CaculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("first_Operand"));
        double sercondOperand = Double.parseDouble(request.getParameter("sercond_Operand"));
        char operator=request.getParameter("operator").charAt(0);
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        try {
            double result=Caculator.calculate(firstOperand,sercondOperand,operator);
            printWriter.println(firstOperand + " " + operator + " " + sercondOperand + " = " + result);
        }catch (Exception e){
            printWriter.println("Error: " + e.getMessage());
        }
        printWriter.println("</html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
