package nikolov.com.shoecalatogueappandroid.http;

import java.io.IOException;

import nikolov.com.shoecalatogueappandroid.Constants;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpRequester implements HttpRequester{

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
    public String getProducts(String url) throws IOException {
        // returns a json map
        return getRequest(url);
    }

    @Override
    public String getProductColors(String url) throws IOException {
        //returns a list of color strings
        url += "/colors";
        return getRequest(url);
    }

    @Override
    public String getSizes(String url) throws IOException {
        //returns a list of integers with sizes
        url += "/sizes";
        return getRequest(url);
    }

    @Override
    public String createProduct(String url, String body) throws IOException {
        url += "/create";
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                body
        );
        Request request = new Request.Builder()
                .put(requestBody)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();
        String responseBody = response.body().string();
        return responseBody;
    }

    @Override
    public String getProductById(String url, int id) throws IOException {
        url+= Integer.toString(id);
        return getRequest(url);
    }

    @Override
    public String updateProduct(String url, int id, String body) throws IOException {
        url += Integer.toString(id);
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
    public String deleteProduct(String url, int id) throws IOException {
        url+= Integer.toString(id);
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

    @Override
    public String get(String url) throws IOException {
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
    public String post(String url, String bodyString) throws IOException {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                bodyString
        );

        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String responseBody = response.body().string();
        return responseBody;
    }
}
