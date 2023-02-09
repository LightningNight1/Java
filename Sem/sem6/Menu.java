package sem.sem6;

import java.util.HashSet;
import java.util.Set;

public class Menu {
    public static void main(String[] args) {
        System.out.println("\nДобро пожаловать в каталог ноутбуков!\nВыберите действие:");
        Set<Laptop> set = new HashSet<>();
        set.add(new Laptop("001", 16, "Windows", 1024, "Samsung"));
        set.add(new Laptop("002", 32, "Windows", 1024, "Lenovo"));
        set.add(new Laptop("003", 8, "linux", 256, "Asus"));
        set.add(new Laptop("004", 8, "Mac", 512, "Apple"));
        set.add(new Laptop("005", 16, "Solaris", 512, "IBM"));

        HW6 HW6 = new HW6(set);
        HW6.start();
        System.out.println("Всего доброго!");
    }
}