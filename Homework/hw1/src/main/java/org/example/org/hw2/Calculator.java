package org.hw2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {
    private static Logger logger = Logger.getLogger(Calculator.class.getName());
    public static void main(String[] args) {
        startCalculator();
    }

//    4*. К калькулятору из предыдущего дз добавить логирование.
    private static void startCalculator(){
        System.out.println("Простой калькулятор");
        Scanner iScan = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = iScan.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = iScan.nextDouble();
        System.out.print("\nВведите оператор (+, -, *, /): ");
        char op = iScan.next().charAt(0);

        iScan.close();

        StringBuilder result = new StringBuilder();

        switch (op){
            case '+':
                result.append(num1).append(op).append(num2).append("=").append(num1 + num2);
                break;
            case '-':
                result.append(num1).append(op).append(num2).append("=").append(num1 - num2);
                break;
            case '*':
                result.append(num1).append(op).append(num2).append("=").append(num1 * num2);
                break;
            case '/':
                if (num2 != 0){
                    result.append(num1).append(op).append(num2).append("=").append(num1 / num2);
                }
                else {
                    result.append("Попытка деления на 0, нельзя делить на 0");
                }
                break;
            default:  result.append("Error!");
                break;
        }
        System.out.println(result);

        try (PrintWriter out = new PrintWriter("log-calculator.txt")){
            out.println(result);
            logger.info("log add");
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
