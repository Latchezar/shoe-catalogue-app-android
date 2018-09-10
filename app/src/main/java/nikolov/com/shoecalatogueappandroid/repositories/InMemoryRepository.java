package nikolov.com.shoecalatogueappandroid.repositories;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;

public class InMemoryRepository<T> implements Repository<T> {
    private final Map<Integer, T> mItems;

    public InMemoryRepository(){
        mItems = new HashMap<>();
    }
    @Override
    public Map<Integer, T> getAll() {
        return mItems;
    }

    @Override
    public T add(int id, T item) {
        mItems.put(id, item);
        return item;
    }

    @Override
    public T getById(int id) {
        return mItems.get(id);
    }

    @Override
    public List<String> getColors() throws IOException {
        return null;
    }

    @Override
    public List<Integer> getSizes() throws IOException {
        return null;
    }

    @Override
    public String delete(int id) throws IOException {
        return null;
    }

    @Override
    public String update(int id, T object) throws IOException {
        return null;
    }
}
