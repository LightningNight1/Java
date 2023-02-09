package sem.sem5.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

public class HW5 {
    public static void main(String[] args) {
        Map<String, List<String>> book = new HashMap<>();
        book.put("Ivan", List.of("89158196248", "89168159275"));
        book.put("Petr", List.of("89609248251", "89952477154"));
        book.put("Sidor", List.of("8800553535", "89056495978"));

        menu(book);
    }

    public static String scan() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static void find(Map<String, List<String>> phoneBook) {
        System.out.print("Имя: ");
        String name = scan();
        System.out.println("Телефон(ы): " + phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> allBook) {
        for (var item : allBook.entrySet()) {
            System.out.println("Имя: " + item.getKey() + "\nТелефон(ы): " + item.getValue());
        }
    }

    public static Map<String, List<String>> add(Map<String, List<String>> book) {
        System.out.print("Имя: ");
        String name = scan();
        List<String> data = new ArrayList<>();
        while (true) {
            System.out.println("Если номеров больше нет, введите '0'");
            System.out.print("Введите номер: ");
            String phoneNumber = scan();
            if (phoneNumber.equals("0")) {
                break;
            } else {
                data.add(phoneNumber);
            }
        }
        book.put(name, data);

        return book;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> book) {
        while (true) {
            System.out.println("\nМеню: \n1. Найти контакт \n2. Добавить контакт" +
                    " \n3. Печать телефонной книги \n4. Выход");
            System.out.print("\nВыберите пункт меню-> ");
            String comands = scan();
            if (comands.equals("4")) {
                break;
            } else {
                switch (comands) {
                    case "1":
                        find(book);
                        break;
                    case "2":
                        add(book);
                        break;
                    case "3":
                        allBook(book);
                        break;
                    default:
                        break;
                }
            }
        }
        return book;
    }
}