import personal.controllers.ToysControllers;
import personal.model.FileOperation;
import personal.model.FileOperationImpl;
import personal.model.Play;
import personal.model.PlayFile;
import personal.views.ViewToys;


public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("toys.txt");
        Play play = new PlayFile(fileOperation);
        ToysControllers controller = new ToysControllers(play);
        ViewToys view = new ViewToys(controller);
        view.run();

    }
}