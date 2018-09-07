package nikolov.com.shoecalatogueappandroid.repositories.base;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();

    T add(T item);

    T getById(int id);
}
