package newDAOPattern;
import java.util.List;

public interface PasswordDAO {
    public void insert(PasswordInfo p);
    public void findAll();
    public PasswordInfo findByKey(String url);
    public void update(String newId,PasswordInfo p);
    public void delete(String url);
    public void delete(PasswordInfo p);
}

