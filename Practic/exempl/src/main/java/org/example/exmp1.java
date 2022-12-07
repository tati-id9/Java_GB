package org.example;
import java.util.Scanner;

public class exmp1 {
//Написать программу, которая запросит пользователя ввести <Имя> в консоли.
//Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
    public static void HelloUser() {
        System.out.println("Введите имя: "); //распечатается введите имя, в одной строке System.out.print
        Scanner str = new Scanner(System.in); // запросит входной параметр
        String name = str.nextLine(); // считать и присвоить значение
        System.out.println("Hello, " + name);
    }

//В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    public static void task2(){

    }

    public static void main(String[] args) {
        HelloUser();
    }

}
