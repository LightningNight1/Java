package oop.sem1;

public class GameMain {

    public static void main(String[] args) {
        // Карта с роботами.
        // Карта имеет nxm, где n и m - положительные целые числа.
        // Должна быть возможность создания робота на какой-то точке на карте.
        // Точка на карте описывается двумя целочисленными координатами.
        // Роботы могут перемещаться по карте вперед.
        // В одной точке не может находиться несколько роботов.

        // HOMEWORK
        // 0. Разобраться с проектом. Подготовить вопросы к следующему семинару, если
        // возникнут.
        // 1. Добавить валидацию параметров при создании карты
        // 2. Реализовать возможность задать ограничение по количеству создаваемых
        // на карте роботов (в конструкторе карты)
        // При этом если параметр не указан, то используем значение по-умолчанию: 5
        // 3*. Реализовать возможность вызова метода move с параметром - количество
        // шагов вперед
        // Подсказка: можно несколько раз вызвать метод #move

        /*
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         */

        RobotMap map = new RobotMap(5, 5);
        RobotMap.Robot robot1 = map.createRobot(new Point(2, 5));
        RobotMap.Robot robot2 = map.createRobot(new Point(5, 5));
        RobotMap.Robot robot3 = map.createRobot(new Point(3, 4));
        RobotMap.Robot robot4 = map.createRobot(new Point(3, 5));
        RobotMap.Robot robot5 = map.createRobot(new Point(4, 5));

        System.out.println(robot1);
        robot1.move(1);
        System.out.println(robot1);
        robot1.changeDirection(Direction.LEFT);
        robot1.move(2);
        robot1.move(1);
        System.out.println(robot1);
    }
}
