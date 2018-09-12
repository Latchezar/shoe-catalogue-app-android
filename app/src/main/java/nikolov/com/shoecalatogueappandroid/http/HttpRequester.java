package nikolov.com.shoecalatogueappandroid.http;

import java.io.IOException;
import java.util.HashMap;

public interface HttpRequester {
    String getProducts(String url) throws IOException;

    String getProductColors(String url) throws IOException;

    String getSizes(String url) throws IOException;

    String createProduct(String url, String body) throws IOException;

    String getProductById(String url, int id) throws IOException;

    String updateProduct(String url, int id, String body) throws IOException;

    String deleteProduct(String url, int id) throws IOException;

    String get(String url) throws IOException;

    String post(String url, String body) throws IOException;

}
