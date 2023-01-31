package sem.sem3.tasks12;

import java.util.ArrayList;
import java.util.Random;

public class HW3 {
    public static void main(String[] args) {
        // Создать список целых чисел (заполнить случайными числами), удалить из списка
        // четные числа.
        task1();
        // Создать список целых чисел (заполнить случайными числами).
        // Найти минимальное, максимальное и среднее из этого списка.
        task2();
    }

    static void task1() {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(i, rand.nextInt(100));
        }
        System.out.println("Whole numbers: " + list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        System.out.println("Odd numbers: " + list + "\n");
    }

    static void task2() {
        ArrayList<Integer> list1 = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            list1.add(i, rand.nextInt(100));
        }
        System.out.println("Whole numbers: " + list1);
        int min = list1.get(0);
        int max = list1.get(0);
        double sum = 0;

        for (int i = 0; i < list1.size(); i++) {
            max = max < list1.get(i) ? list1.get(i) : max;
            min = min > list1.get(i) ? list1.get(i) : min;
            sum += list1.get(i);
        }

        System.out.println("Max : " + max +
                "\nMin : " + min +
                "\nAverage : " + sum / list1.size());

    }

}