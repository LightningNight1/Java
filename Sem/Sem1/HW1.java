package sem.sem1;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        // Вычислить сумму чисел от 1 до n, вычислить n! произведение чисел от 1 до n
        // task1();

        // Вывести все простые числа от 1 до 1000
        // task2();

        // Реализовать простой калькулятор (операции + - / * )
        task3();

    }

    static void task1() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = iScanner.nextInt();
        iScanner.close();
        int triangularNum = 0;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            triangularNum += i;
            factorial *= i;
        }

        System.out.println("Triangular number " + num + " = " + triangularNum);
        System.out.println("Factorial " + num + " = " + factorial);
    }

    static void task2() {
        int primeNums = 1000;
        System.out.printf("Prime numbers from 0 to %s: ", primeNums);
        for (int i = 2; i < primeNums; ++i) {
            int count = 0;
            for (int j = 2; j <= i && count < 2; ++j) {
                if (i % j == 0) {
                    ++count;
                }
            }
            if (count < 2) {
                System.out.print(i + " ");
            }
        }
    }

    static void task3() {
        double num1;
        double num2;
        double res = 0;
        char operation;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        num2 = sc.nextInt();
        System.out.print("\nEnter the operation (+, -, *, /): ");
        operation = sc.next().charAt(0);
        sc.close();
        if (operation == '+') {
            res = num1 + num2;
            System.out.printf(num1 + " " + operation + " " + num2 + " = " + res);
        } else if (operation == '-') {
            res = num1 - num2;
            System.out.printf(num1 + " " + operation + " " + num2 + " = " + res);
        } else if (operation == '*') {
            res = num1 * num2;
            System.out.printf(num1 + " " + operation + " " + num2 + " = " + res);
        } else if (operation == '/') {
            res = num1 / num2;
            System.out.printf(num1 + " " + operation + " " + num2 + " = " + res);
        } else
            System.out.printf("Invalid value. Enter the operation (+, -, *, /)");
    }
}