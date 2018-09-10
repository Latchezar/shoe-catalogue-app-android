package nikolov.com.shoecalatogueappandroid.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import nikolov.com.shoecalatogueappandroid.models.Product;
import nikolov.com.shoecalatogueappandroid.repositories.base.Repository;
import nikolov.com.shoecalatogueappandroid.services.base.ProductService;

public class HttpProductService implements ProductService {
    private final Repository<Product> mProductRepository;

    public HttpProductService(
            Repository<Product> productRepository
    ){
        mProductRepository = productRepository;
    }

    @Override
    public Map<Integer, Product> getAllProducts() throws IOException {
        return mProductRepository.getAll();
    }

    @Override
    public Product getProductById(int id) throws IOException {
        return mProductRepository.getById(id);
    }

    @Override
    public Product createProduct(Product product) throws IOException {
        return mProductRepository.add(product.getId(), product);
    }

    @Override
    public List<String> getColors() throws IOException {
        return mProductRepository.getColors();
    }

    @Override
    public List<Integer> getSizes() throws IOException {
        return mProductRepository.getSizes();
    }

    @Override
    public String updateProduct(int id, Product product) throws IOException {
        return mProductRepository.update(id, product);
    }

    @Override
    public String deleteProduct(Product product) throws IOException {
        return mProductRepository.delete(product.getId());
    }

    @Override
    public String deleteProduct(int id) throws IOException {
        return mProductRepository.delete(id);
    }
}
