package nikolov.com.shoecalatogueappandroid.parsers.base;

import java.util.List;
import java.util.Map;

public interface JsonParser<T> {
    Map<Integer, T> fromJsonToMap(String jsonString);
    List<Integer> fromJasonArrayToIntegerArray(String jsonString);
    List<String> fromJsonArray(String jsonString);
    String toJson(T object);
    T fromJson(String jsonString);

}
