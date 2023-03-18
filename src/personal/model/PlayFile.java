package personal.model;

import java.util.ArrayList;
import java.util.List;

public class PlayFile implements Play{
    private ToysMapper mapper = new ToysMapper();
    private FileOperation fileOperation;
    public PlayFile(FileOperation fileOperation){
        this.fileOperation = fileOperation;
    }
    @Override
    public List<Toys> getAllToys() {
        List<String> lines = fileOperation.readAllLines();
        List<Toys> toyses = new ArrayList<>();
        for (String line : lines) {
            toyses.add(mapper.map(line));
        }
        return toyses;
    }

    @Override
    public String CreateToys(Toys toys) {
        List<Toys> toyses = getAllToys();
        int max = 0;
        for (Toys item : toyses) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        toys.setId(id);
        toyses.add(toys);
        writeDown(toyses);
        return id;
    }

    @Override
    public void updateToys(Toys toys) {
        List<Toys> toyses = getAllToys();
        Toys target = toyses.stream().filter(i->i.getId().equals(toys.getId())).findFirst().get();
        target.setName(toys.getName());
        target.setCount(toys.getCount());
        target.setChance(toys.getChance());
        writeDown(toyses);
    }

    @Override
    public void deleteByID(String inputId) {
        List<Toys> toyses = getAllToys();
        Toys target = toyses.stream().filter(i->i.getId().equals(inputId)).findFirst().get();
        toyses.remove(target);
        writeDown(toyses);
    }

    private void writeDown(List<Toys> toyses) {
        List<String> lines = new ArrayList<>();
        for (Toys item:toyses){
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

}
