package sem.sem6;

import java.util.*;

public class HW6 {
    private Set<Laptop> laptops = new HashSet<>();
    private List<Criterion> criterionList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void printList() {
        for (Laptop laptop : laptops) {
            if (laptopIsCorrect(laptop)) {
                System.out.println(laptop);
            }
        }
    }

    public boolean laptopIsCorrect(Laptop laptop) {
        for (Criterion criterion : criterionList) {
            Object valueLaptop = null;

            if (criterion.property.equals("name")) {
                valueLaptop = laptop.getId();
            } else if (criterion.property.equals("RAM")) {
                valueLaptop = laptop.getRam();
            } else if (criterion.property.equals("oS")) {
                valueLaptop = laptop.getoS();
            } else if (criterion.property.equals("hard")) {
                valueLaptop = laptop.getHard();
            } else if (criterion.property.equals("model")) {
                valueLaptop = laptop.getModel();
            } else {
                continue;
            }

            if (criterion.value != null && !criterion.value.equals(valueLaptop)) {
                return false;
            }

            if (criterion.maxValue != null
                    && criterion.maxValue < Double.parseDouble(Objects.toString(valueLaptop))) {
                return false;
            }

            if (criterion.minValue != null
                    && criterion.minValue > Double.parseDouble(Objects.toString(valueLaptop))) {
                return false;
            }
        }
        return true;
    }

    public HW6(Set<Laptop> laptops) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
    }

    public HW6(Set<Laptop> laptops, List<Criterion> criterionList) {
        this.scanner = new Scanner(System.in);
        this.laptops = laptops;
        this.criterionList = criterionList;
    }

    public int getCriteria() {
        String text = "\nВведите цифру, соответствующую критерию поиска: ";
        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++) {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }
        System.out.println(text);
        System.out.print("\nНеобходимый критерий: \n");
        int value = scanner.nextInt();
        return value;
    }

    public String getPropertyDescription(String property) {
        Map<String, String> descriptionsProperties = descriptionsProperties();
        return descriptionsProperties.get(property);
    }

    public Map<String, String> descriptionsProperties() {
        Map<String, String> map = new HashMap<>();

        map.put("name", "по Id");
        map.put("RAM", "Объем оперативной памяти");
        map.put("oS", "Операционная система");
        map.put("hard", "Объем ЖД");
        map.put("model", "Модель");
        return map;
    }

    public List<String> propertiesForFilter() {
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("RAM");
        list.add("oS");
        list.add("hard");
        list.add("model");
        return list;
    }

    public String getHW6s() {
        String text = "\n 1. Поиск по параметрам\n " +
                "2. Печать всех товаров\n " +
                "3. Выход";
        System.out.println(text);
        System.out.print(" Сделайте выбор: \n");
        String answer = scanner.next();
        return answer;
    }

    public Set<String> quantitativeSelection() {
        Set<String> set = new HashSet<>();
        set.add("RAM");
        set.add("hard");
        return set;
    }

    public Set<String> stringSelection() {
        Set<String> set = new HashSet<>();
        set.add("name");
        set.add("oS");
        set.add("model");
        return set;
    }

    public void start() {
        boolean flag = true;
        while (flag) {
            String HW6 = getHW6s();
            if (HW6.equals("3")) {
                flag = false;
                scanner.close();
                continue;
            } else if (HW6.equals("1")) {

                int criterion = getCriteria();
                List<String> properties = propertiesForFilter();
                if (criterion - 1 < 0 || criterion - 1 > properties.size() - 1) {
                    System.out.println("Введено некорректное значение");
                    continue;
                }
                String property = properties.get(criterion - 1);
                Criterion criterionObject = null;
                try {
                    if (quantitativeSelection().contains(property)) {
                        criterionObject = Criterion.startGetting(scanner, property, true);
                    } else {
                        criterionObject = Criterion.startGetting(scanner, property, false);
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка при выборе");
                    continue;
                }
                if (criterionObject != null) {
                    System.out.println("Ваш критерий добавлен");
                    criterionList.add(criterionObject);
                    System.out.println("Промежуточный итог: \n");
                    printList();
                }
            } else if (HW6.equals("2")) {
                printList();
            }
        }
    }
}

class Criterion {

    Object value;
    Double minValue;
    Double maxValue;
    boolean isQuantitative;
    String property;

    public Criterion(String property, boolean isQuantitative, Object value, Double minValue, Double maxValue) {
        this.property = property;
        this.isQuantitative = isQuantitative;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Criterion startGetting(Scanner scanner, String property, boolean isQuantitative) {
        if (isQuantitative) {
            String quest = "Выберите тип критерия: " +
                    "\n 1. По значению" +
                    "\n 2. Меньше заданного" +
                    "\n 3. Больше заданного" +
                    "\n 4. Интервал";
            System.out.println(quest);
            System.out.print("Выбор -> ");
            String text = scanner.next();
            Criterion criterion = null;
            if (text.equals("1")) {
                System.out.print("Введите значение -> ");
                int getValue = scanner.nextInt();
                criterion = new Criterion(property, isQuantitative, getValue, null, null);
            } else if (text.equals("2")) {
                System.out.print("Введите максимальное предельное значение -> ");
                double getValue = scanner.nextDouble();
                criterion = new Criterion(property, isQuantitative, null, null, getValue);
            } else if (text.equals("3")) {
                System.out.print("Введите минимальное предельное значение -> ");
                double getValue = scanner.nextDouble();
                criterion = new Criterion(property, isQuantitative, null, getValue, null);
            } else if (text.equals("4")) {
                System.out.print("Введите минимальное предельное значение -> ");
                double getMin = scanner.nextDouble();
                System.out.print("Введите максимальное предельное значение -> ");
                double getMax = scanner.nextDouble();
                criterion = new Criterion(property, isQuantitative, null, getMin, getMax);
            }
            return criterion;
        }
        System.out.print("Введите значение -> ");
        String getValue = scanner.next();
        return new Criterion(property, isQuantitative, getValue, null, null);
    }

}