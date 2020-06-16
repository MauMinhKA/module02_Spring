import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChietKhau",urlPatterns = "/chietkhau")
public class ChietKhau extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
        double DiscountPercent = Double.parseDouble(request.getParameter("DiscountPercent"));
        double Amount=priceProduct*DiscountPercent*0.01;
        double DiscountPrice=priceProduct+Amount;

        PrintWriter writer=response.getWriter();
        writer.println("<html>");

        writer.println("<h1>Discount Amount: " + Amount + "</h1>");
        writer.println("<h1>Discount Price: " + DiscountPrice + "</h1>");

        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index4.jsp");
    }
}