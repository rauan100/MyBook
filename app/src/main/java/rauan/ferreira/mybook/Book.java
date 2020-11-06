package rauan.ferreira.mybook;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Book {
    public String name;
    public String title;
    public String authors;
    public String status;
    public String quantity;

    public Book() {

    }

    public Book(String name, String title, String quantity, String authors, String status) {
        this.name = name;
        this.title = title;
        this.quantity = quantity;
        this.authors = authors;
        this.status = status;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("title", title);
        result.put("quantity", quantity);
        result.put("authors", authors);
        result.put("status", status);

        return result;
    }
}
