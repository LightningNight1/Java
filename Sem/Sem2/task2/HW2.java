package sem.sem2.task2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Date;

// К калькулятору из предыдущего дз добавить логирование.

public class HW2 {
    public static void main(String[] args) throws SecurityException, IOException {
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

        Date date = new Date();

        Logger logger = Logger.getLogger(HW2.class.getName());
        FileHandler fh = new FileHandler(
                "CalcLog.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.info(date.toString());
        logger.info("The user entered the first number = " + num1);
        logger.info("The user entered the second number = " + num2);
        logger.info("The user entered the operation '" + operation + "'");
        logger.info("The user received the response : " + num1 + " " + operation + " " + num2 + " = " + res + "\n");
    }
}