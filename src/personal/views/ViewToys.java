package personal.views;

import personal.controllers.ToysControllers;
import personal.model.Toys;

import java.util.List;
import java.util.Scanner;

public class ViewToys {
    private ToysControllers toysControllers;
    public ViewToys (ToysControllers toysControllers){
        this.toysControllers = toysControllers;
    }
    public void run(){
        Commands commands = Commands.NONE;
        while (true){
            String command = prompt("Введите команду: ");
            commands = Commands.valueOf(command.toUpperCase());
            if (commands == Commands.EXIT) return;
            try {
            switch (commands){
                case CREATE:
                    String name = prompt("Название: ");
                    String count = prompt("Количество: ");
                    String chance = prompt("Вероятность выпадения: ");
                    toysControllers.saveToys(new Toys(name,count,chance));
                    break;
                case PLAY:
                    List<Toys> list=toysControllers.readList();
                    Toys toys = toysControllers.getRandomElement(list);
                    System.out.println("Вы выиграли!!!");

                    System.out.println(toysControllers.getRandomElement(list));

                    break;
                case LIST:
                    List<Toys> lst=toysControllers.readList();
                    lst.forEach(i-> System.out.println(i+"\n"));
                    break;
            }
            }catch (Exception e){
                System.out.println("ERROR\n"+e.getMessage());
            }
        }
    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private Toys creatAGuy(){
        String name = prompt("Название: ");
        String count = prompt("Количество: ");
        String chance = prompt("Вероятность выпадения: ");
        Toys newGuy = new Toys(name, count, chance);
        return newGuy;
    }
}
