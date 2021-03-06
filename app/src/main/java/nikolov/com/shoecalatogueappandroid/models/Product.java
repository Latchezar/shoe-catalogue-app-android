package nikolov.com.shoecalatogueappandroid.models;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable{
    public int id;
    public String name, model, description, imagePath;
    public int price;
    public List<Colors> Colors;
    public List<Integer> Sizes;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
