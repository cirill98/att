package personal.model;

import java.util.List;

public interface Play {
    List<Toys> getAllToys();
    String CreateToys(Toys toys);
    void updateToys (Toys toys);
    void deleteByID(String inputId);
}
