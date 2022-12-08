package org.example;

import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        System.out.println("Введите номер задачи от 1 до 3");
        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();

        switch (n){
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            default:
                System.out.println("вы неверно ввели номер задачи");
                break;
        }
    }
    /**Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)*/
    public static void task1(){
        System.out.println("n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)");
        System.out.println("Введите n:");
        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();
        iScan.close();
        int number = (n * ( n + 1 ))/2;
        System.out.println("N-ое равно: " + number);
    }

    /** Вывести все простые числа от 1 до 1000*/
    public static void task2(){
        System.out.println("Вывести все простые числа от 1 до 1000)");
        int value = 1000;
        for (int i=2;i<value;i++){
            if(checkSimple(i))
                System.out.printf("%d ", i);
        }
    }
    public static boolean checkSimple(int i){
        if (i<=1)
            return false;
        else if (i <=3)
            return true;
        else if (i%2==0 || i %3 ==0)
            return false;
        int n = 5;
        while (n*n <=i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }

    /**Реализовать простой калькулятор*/
    public static void task3(){
        System.out.println("Простой калькулятор");
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = reader.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = reader.nextDouble();
        System.out.print("\nВведите оператор (+, -, *, /): ");
        char op = reader.next().charAt(0);

        reader.close();

        switch (op){
            case '+':
                System.out.printf(num1 + " " + op + " " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                System.out.printf(num1 + " " + op + " " + num2 + " = " + (num1 - num2));
                break;
            case '*':
                System.out.printf(num1 + " " + op + " " + num2 + " = " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0){
                    System.out.printf(num1 + " " + op + " " + num2 + " = " + (num1 / num2));
                }
                else {
                    System.out.println("нельзя делить на 0");
                }
                break;
            default:  System.out.printf("Error!");
                return;
        }
    }
}
