import java.util.List;

public interface Service<T> {
    List<T> findAll();
    T findById(int id);
    void deletebyId(int id);
    void save(T t);
}
