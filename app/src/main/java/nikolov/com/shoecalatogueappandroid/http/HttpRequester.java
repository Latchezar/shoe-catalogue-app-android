package nikolov.com.shoecalatogueappandroid.http;

import java.io.IOException;
import java.util.HashMap;

public interface HttpRequester {
    String getProducts() throws IOException;

    String getProductColors() throws IOException;

    String getSizes() throws IOException;

    String createProduct(String body) throws IOException;

    String getProductById(int id) throws IOException;

    String updateProduct(int id, String body) throws IOException;

    String deleteProduct(int id) throws IOException;
}
