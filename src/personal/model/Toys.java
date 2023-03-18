package personal.model;

public class Toys {
    private String id = "";
    private String name;
    private String count;
    private String chance;


    public Toys(String name, String count, String chance) {
        this.name = name;
        this.count = count;
        this.chance = chance;
    }
    public Toys(String id, String name, String count, String chance) {
        this(name, count, chance);
        this.id = id;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getChance() {
        return chance;
    }

    public void setChance(String chance) {
        this.chance = chance;
    }
        @Override
        public String toString() {
            return String.format("Идентафикатор: %s\nИмя: %s,\nКоличество: %s,\nВероятность: %s", id, name, count, chance);
        }
    }
