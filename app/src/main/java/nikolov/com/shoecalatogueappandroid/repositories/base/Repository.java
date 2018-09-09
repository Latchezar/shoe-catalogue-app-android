package nikolov.com.shoecalatogueappandroid.repositories.base;

import java.util.List;
import java.util.Map;

public interface Repository<T> {
    Map<Integer, T> getAll();

    T add(int id, T item);

    T getById(int id);
}
