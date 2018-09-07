package nikolov.com.shoecalatogueappandroid.parsers.base;

import java.util.List;

public interface JsonParser<T> {
    List<T> fromJsonArray(String jsonString);
    String toJson(T object);
    T fromJson(String jsonString);

}
