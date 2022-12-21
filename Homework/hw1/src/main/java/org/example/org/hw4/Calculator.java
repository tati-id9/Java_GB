package org.example.org.hw4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {
    private static Logger logger = Logger.getLogger(Calculator.class.getName());
    public static void main(String[] args) {
        startCalculator();
    }

//    3. В калькулятор добавьте возможность отменить последнюю операцию.
    private static void startCalculator(){
        System.out.println("Простой калькулятор");
        Scanner iScan = new Scanner(System.in);
        try (PrintWriter out = new PrintWriter("log-calculator.txt")){
            System.out.print("Введите первое число: ");
            double num1 = iScan.nextDouble();
            out.println("значение 1: " + num1);
            System.out.print("Введите второе число: ");
            double num2 = iScan.nextDouble();
            out.println("значение 2: " + num2);
            System.out.print("Введите оператор (+, -, *, /): ");
            char op = iScan.next().charAt(0);
            out.println("операция: " + op);

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

            out.println("итог: "+ result);
            logger.info("log add");
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
