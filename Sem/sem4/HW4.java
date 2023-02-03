package sem.sem4;

import java.util.LinkedList;
import java.util.Random;

public class HW4 {
    public static void main(String[] args) {
        // Создать LinkedList целых чисел (заполнить случайными числами).
        // Реализуйте метод, который вернет “перевернутый” список.
        task1();

        // Создать очередь с помощью LinkedList и реализовать следующие методы:
        // enqueue() - помещает элемент в конец очереди,
        // dequeue() - возвращает первый элемент из очереди и удаляет его,
        // first() - возвращает первый элемент из очереди, не удаляя.
        // Вызвать полученные методы и убедиться в их работоспособности.
        task2();

    }

    public static void task1() {
        LinkedList<Integer> linList = new LinkedList<>();
        Random rand = new Random();

        for (int i = 0; i < 8; i++) {
            linList.add(rand.nextInt(50));
        }
        System.out.println(linList);
        System.out.println(reverse(linList));
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> listInit) {
        LinkedList<Integer> resList = new LinkedList<>();
        for (int i = listInit.size() - 1; i > -1; i--) {
            resList.add(listInit.get(i));
        }
        return resList;
    }

    public static void task2() {
        LinkedList<Integer> linList = new LinkedList<>();
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            linList.add(rand.nextInt(10));
        }
        System.out.println(linList);
        enqueue(linList, 99);
        dequeue(linList);
        System.out.println(first(linList));
    }

    public static LinkedList<Integer> enqueue(LinkedList<Integer> list, int num) {
        list.addLast(num);
        System.out.println(list);
        return list;
    }

    public static int dequeue(LinkedList<Integer> list) {
        int temp = list.get(0);
        list.remove(0);
        System.out.println(list);
        return temp;
    }

    public static int first(LinkedList<Integer> list) {
        return list.get(0);
    }
}