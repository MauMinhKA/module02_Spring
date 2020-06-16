import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> listCustomer;

    static {
        listCustomer = new HashMap<>();
        listCustomer.put(1, new Customer(1, "truong khanh mau", "mauminhka@gmail.com", "ha tinh"));
        listCustomer.put(2, new Customer(2, "nguyen truong giang", "truonggiang@gmail.com", "ha tinh"));
        listCustomer.put(3, new Customer(3, "truong dinh bac", "dinhbac@gmail.com", "ha tinh"));
        listCustomer.put(4, new Customer(4, "dong phuc tri", "phuctri@gmail.com", "ha tinh"));
        listCustomer.put(5, new Customer(5, "nguyen bao an", "baoan@gmail.com", "ha tinh"));
        listCustomer.put(6, new Customer(6, "le hong phong", "hongphong@gmail.com", "ha tinh"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(listCustomer.values());
    }

    @Override
    public Customer findById(int id) {
        return listCustomer.get(id);
    }

    @Override
    public void deletebyId(int id) {
        listCustomer.remove(id);

    }

    @Override
    public void save(Customer customer) {
        listCustomer.put(customer.getId(), customer);
    }
}
