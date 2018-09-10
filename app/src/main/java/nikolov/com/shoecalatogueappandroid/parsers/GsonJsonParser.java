package nikolov.com.shoecalatogueappandroid.parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import nikolov.com.shoecalatogueappandroid.parsers.base.JsonParser;

public class GsonJsonParser<T> implements JsonParser<T>{
    private final Class<T> mClazz;
    private final Class<T[]> mArrayClazz;
    private final Gson mGson;

    public GsonJsonParser(Class<T> clazz, Class<T[]> arrayClazz){
        mClazz = clazz;
        mArrayClazz = arrayClazz;
        mGson = new Gson();
    }

    @Override
    public Map<Integer, T> fromJsonToMap(String jsonString) {
        Type type = new TypeToken<Map<Integer, T>>(){}.getType();
        Map<Integer, T> result = mGson.fromJson(jsonString, type);
        return result;
    }

    @Override
    public List<Integer> fromJasonArrayToIntegerArray(String jsonString) {
        Integer[] result = mGson.fromJson(jsonString, Integer[].class);
        return Arrays.asList(result);
    }

    @Override
    public List<String> fromJsonArray(String jsonString) {
        String[] result = mGson.fromJson(jsonString, String[].class);
        //String[] result = mGson.fromJson(jsonString, String);
        return Arrays.asList(result);
    }

    @Override
    public String toJson(T object) {
        return mGson.toJson(object);
    }

    @Override
    public T fromJson(String jsonString) {
        return mGson.fromJson(jsonString, mClazz);
    }
}
