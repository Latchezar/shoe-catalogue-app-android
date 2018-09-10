package nikolov.com.shoecalatogueappandroid.models;

import java.util.List;

public class Product {
    private int id;
    private String name, model, description, imagePath;
    private int price;
    private List<Colors> Colors;
    private List<Integer> Sizes;

    public int getId() {
        return id;
    }
}
