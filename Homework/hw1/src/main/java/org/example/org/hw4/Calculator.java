package org.example.org.hw4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {
    private static Logger logger = Logger.getLogger(Calculator.class.getName());

    public static void main(String[] args) {
        LinkedList<Double> operation = new LinkedList<Double>();
        System.out.println("Простой калькулятор");
        try (PrintWriter out = new PrintWriter("log-calculator.txt")) {
            startCalculator(operation, out);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(operation);
    }

    //    3. В калькулятор добавьте возможность отменить последнюю операцию.
    private static LinkedList<Double> startCalculator(LinkedList<Double> operation, PrintWriter out) {
        Scanner iScan = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        System.out.print("Введите оператор (+, -, *, /, cancel): ");
        String op = iScan.next();
        out.println("операция: " + op);
        if (op.contains("cancel")) {
            operation.removeLast();
            result.append("отмена последней операции");
        } else {
            System.out.print("Введите первое число: ");
            double num1 = iScan.nextDouble();
            out.println("значение 1: " + num1);
            System.out.print("Введите второе число: ");
            double num2 = iScan.nextDouble();
            out.println("значение 2: " + num2);
            switch (op) {
                case "+":
                    operation.add(num1 + num2);
                    result.append(num1).append(op).append(num2).append("=").append(num1 + num2);
                    break;
                case "-":
                    operation.add(num1 - num2);
                    result.append(num1).append(op).append(num2).append("=").append(num1 - num2);
                    break;
                case "*":
                    operation.add(num1 * num2);
                    result.append(num1).append(op).append(num2).append("=").append(num1 * num2);
                    break;
                case "/":
                    if (num2 != 0) {
                        operation.add(num1 / num2);
                        result.append(num1).append(op).append(num2).append("=").append(num1 / num2);
                    } else {
                        result.append("Попытка деления на 0, нельзя делить на 0");
                    }
                    break;
                default:
                    result.append("Error!");
                    break;
            }
        }
        System.out.println(result);
        out.println("итог: " + result);
        String flag = iScan.next();
        if (!flag.contains("stop")) {
            return startCalculator(operation, out);
        } else {
            iScan.close();
            logger.info("log add");
            return operation;
        }
    }
}