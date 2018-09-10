package nikolov.com.shoecalatogueappandroid.repositories.base;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Repository<T> {
    Map<Integer, T> getAll() throws IOException;

    T add(int id, T item) throws IOException;

    T getById(int id) throws IOException;

    List<String> getColors() throws IOException;

    List<Integer> getSizes() throws IOException;

    String delete(int id) throws IOException;

    String update(int id, T object) throws IOException;


}
