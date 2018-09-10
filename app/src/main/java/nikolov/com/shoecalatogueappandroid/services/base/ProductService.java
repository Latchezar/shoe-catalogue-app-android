package nikolov.com.shoecalatogueappandroid.services.base;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import nikolov.com.shoecalatogueappandroid.models.Product;

public interface ProductService {
    Map<Integer, Product> getAllProducts() throws IOException;

    Product getProductById(int id) throws IOException;

    Product createProduct(Product product) throws IOException;

    List<String> getColors() throws IOException;

    List<Integer> getSizes() throws IOException;

    String updateProduct(int id, Product product) throws IOException;

    String deleteProduct(Product product) throws IOException;

    String deleteProduct(int id) throws IOException;
}
