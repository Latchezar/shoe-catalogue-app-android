package nikolov.com.shoecalatogueappandroid.parsers;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

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
    public List<T> fromJsonArray(String jsonString) {
        T[] result = mGson.fromJson(jsonString, mArrayClazz);
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
