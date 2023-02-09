package sem.sem5.task2;

import java.util.HashMap;
import java.util.Map;

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

public class HW5 {
    public static void main(String[] args) {
        Map<String, Integer> listWorkers = new HashMap<>();
        String workers = "Светлана Петрова Кристина Белова Анна Мусина Анна Крутова " +
                "Иван Юрин Петр Лыков Павел Чернов Петр Чернышов Мария Федорова " +
                "Марина Светлова Иван Савин Мария Рыкова Марина Лугова " +
                "Анна Владимирова Иван Мечников Петр Петин Иван Ежов ";

        String[] names = workers.split(" ");
        for (int i = 0; i < names.length; i += 2) {
            if (listWorkers.containsKey(names[i])) {
                listWorkers.replace(names[i], listWorkers.get(names[i]) + 1);
            } else {
                listWorkers.put(names[i], 1);
            }
        }
        System.out.println("\nСписок имён:");
        System.out.println(listWorkers);

        System.out.println("\nСписок имён по популярности:");
        listWorkers.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

}