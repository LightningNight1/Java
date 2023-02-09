package sem.sem6;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private String id;

    private int ram;
    private String oS;
    private int hard;
    private String model;

    public Laptop(String id, int ram, String oS, int hard, String model) {
        this.id = id;
        this.ram = ram;
        this.oS = oS;
        this.hard = hard;
        this.model = model;
    }

    public static List<String> propertiesForFilter() {
        List<String> list = new ArrayList<>();
        list.add("ram");
        list.add("oS");
        list.add("hard");
        list.add("model");

        return list;
    }

    @Override
    public String toString() {
        return "Ноутбук: (" + id + "): " +
                "Оперативная память:" + ram +
                ", Операционная система: " + oS + '\'' +
                ", Объем ЖД: " + hard +
                ", Модель: " + model;
    }

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int RAM) {
        this.ram = RAM;
    }

    public String getoS() {
        return oS;
    }

    public void setoS(String oS) {
        this.oS = oS;
    }

    public int getHard() {
        return hard;
    }

    public void setHard(int hdd) {
        this.hard = hdd;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}