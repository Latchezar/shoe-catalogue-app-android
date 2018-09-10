package nikolov.com.shoecalatogueappandroid.http;

import java.io.IOException;

import nikolov.com.shoecalatogueappandroid.Constants;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpRequester implements HttpRequester{
    private final String BASE_URL;
    public OkHttpRequester(){
        BASE_URL = Constants.SERVER_URL_BASE;
    }

    @Override
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response respone = client.newCall(request)
                .execute();

        String body = respone.body().string();
        return body;
    }

    @Override
    public String post(String url, String body) throws IOException {

    }

    private String getRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String body = response.body().string();
        return body;
    }


    @Override
    public String getProducts() throws IOException {
        String url = BASE_URL + "/api/products";
        // returns a json hashmap
        return getRequest(url);
    }

    @Override
    public String getProductColors() throws IOException {
        //returns a list of color strings
        String url = BASE_URL + "api/products/colors";
        return getRequest(url);
    }

    @Override
    public String getSizes() throws IOException {
        //returns a list of integers with sizes
        String url = BASE_URL + "api/products/sizes";
        return getRequest(url);
    }

    @Override
    public String createProduct(String body) throws IOException {

        return null;
    }

    @Override
    public String getProductById(int id) throws IOException {
        String url = BASE_URL + "api/products/" + id;
        return getRequest(url);
    }

    @Override
    public String updateProduct(int id, String body) throws IOException {
        String url = BASE_URL + "/api/products/create";
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                body
        );
        Request request = new Request.Builder()
                .post(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String responseBody = response.body().string();
        return responseBody;
    }

    @Override
    public String deleteProduct(int id) throws IOException {
        String url = BASE_URL + "/api/products/" + id;
        Request request = new Request.Builder()
                .delete()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();
        String responseBody = response.body().string();
        return responseBody;
    }
}
