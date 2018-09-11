package nikolov.com.shoecalatogueappandroid.models;

import java.util.List;

public class Product {
    public int id;
    public String name, model, description, imagePath;
    public int price;
    public List<Colors> Colors;
    public List<Integer> Sizes;

    public int getId() {
        return id;
    }
}
