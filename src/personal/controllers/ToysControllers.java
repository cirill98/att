package personal.controllers;

import personal.model.Play;
import personal.model.Toys;

import java.util.List;

public class ToysControllers {
    private final Play play;

    public ToysControllers(Play play) {
        this.play = play;
    }
    public void saveToys (Toys toys) throws Exception {
        validateToys(toys);
        play.CreateToys(toys);
    }
    public Toys readToys(String userId) throws Exception {
        List<Toys> toyses = play.getAllToys();
        for (Toys toys : toyses) {
            if (toys.getId().equals(userId)) {
                return toys;
            }
        }

        throw new Exception("User not found");
    }
    public List<Toys> readList(){
        List<Toys> result = play.getAllToys();
        return result;
    }
    public void updateToys(String idNumber, Toys newGuy) throws Exception {
        idPresenceValidation(idNumber);
        newGuy.setId(idNumber);
        validateToysId(newGuy);
        play.updateToys(newGuy);
    }
    private void validateToys(Toys toys) throws Exception {

        if (toys.getName().contains(" "))
            throw new Exception("User name has unacceptable characters");
        if (toys.getCount().contains(" "))
            throw new Exception("User name has unacceptable characters");
    }
    private void validateToysId (Toys toys) throws Exception {

        if (toys.getId().isEmpty())
            throw new Exception("User not found");
        validateToys(toys);
    }
    public void idPresenceValidation (String inutId) throws Exception {
        List<Toys> toyses = play.getAllToys();
        for (Toys n: toyses){
            if(n.getId().equals(inutId))
                return;
        }
        throw new Exception("No such ID here");
    }


    public void deleteById(String delId) {
        play.deleteByID(delId);
    }
}
