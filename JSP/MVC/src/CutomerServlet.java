import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CutomerServlet", urlPatterns = "/customers")
public class CutomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                saveCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer=new Customer(id,name,email,address);
        customerService.save(customer);
        request.setAttribute("message","Edited Customer");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("views/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer=new Customer(10,name,email,address);
        customerService.save(customer);
        request.setAttribute("message","create Customer");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("views/create.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                getCreatePage(request, response);
                break;
            case "edit":
                getEditpage(request,response);
                break;
            case "delete":
                break;
            default:
                getHomeCustomer(request, response);
        }
    }

    private void getEditpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=customerService.findById(id);
        request.setAttribute("customer",customer);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("views/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getHomeCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("listCustomer", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
