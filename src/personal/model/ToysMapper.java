package personal.model;

public class ToysMapper {
    public String map(Toys toys) {
        return String.format("%s;%s;%s;%s", toys.getId(), toys.getName(), toys.getCount(), toys.getChance());

    }

    public Toys map(String line) {
        String[] lines = line.split(";");
        return new Toys(lines[0], lines[1], lines[2], lines[3]);
    }
}
