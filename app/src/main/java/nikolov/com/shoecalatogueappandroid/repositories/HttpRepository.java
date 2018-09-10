package nikolov.com.shoecalatogueappandroid.repositories;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import nikolov.com.shoecalatogueappandroid.http.HttpRequester;
import nikolov.com.shoecalatogueappandroid.parsers.base.JsonParser;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;

public class HttpRepository<T> implements Repository<T>{
    private final HttpRequester mHttpRequester;
    private final JsonParser<T> mJsonParser;
    private final String mServerUrl;

    public HttpRepository(
            String serverUrl,
            HttpRequester httpRequester,
            JsonParser<T> jsonParser
    ) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public Map<Integer, T> getAll() throws IOException {
        String jsonString = mHttpRequester.getProducts(mServerUrl);
        Map<Integer, T> result = mJsonParser.fromJsonToMap(jsonString);
        return result;
    }

    @Override
    public T add(int id, T item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.createProduct(mServerUrl, requestBody);
        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public T getById(int id) throws IOException {
        String json = mHttpRequester.getProductById(mServerUrl, id);
        return mJsonParser.fromJson(json);
    }

    @Override
    public List<String> getColors() throws IOException {
        String json = mHttpRequester.getProductColors(mServerUrl);
        List<String> result = mJsonParser.fromJsonArray(json);
        return result;
    }

    @Override
    public List<Integer> getSizes() throws IOException {
        String json = mHttpRequester.getSizes(mServerUrl);
        List<Integer> result = mJsonParser.fromJasonArrayToIntegerArray(json);
        return result;
    }

    @Override
    public String delete(int id) throws IOException {
        String json = mHttpRequester.deleteProduct(mServerUrl, id);
        return json;
    }


    @Override
    public String update(int id, T object) throws IOException {
        String json = mHttpRequester.updateProduct(mServerUrl, id, mJsonParser.toJson(object));
        return json;
    }
}
