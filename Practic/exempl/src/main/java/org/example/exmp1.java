package org.example;
import java.time.LocalTime;
import java.util.Arrays;
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
        System.out.print("Введите имя: ");
        Scanner str = new Scanner(System.in);
        String name = str.nextLine();
        //LocalDate dateTime = LocalDate.now(ZoneId.systemDefault());
        // LocalDate deteNow =
        //switch (dateTime) {
        //    case dateTime
        //}
    }
//Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
    public static void task3(){
        int[] arr = {1, 1, 1, 1, 0, 1, 1, 1};
        int result = CountNumber(arr);
        System.out.println(result);
    }
    public static int CountNumber(int [] arr){
        int count = 0;
        int max = 0;
        for (int elem: arr) {
            if (elem == 0){
                count =0;
            }
            else{
                count++;
            }
            if (max<= count){
                max = count;
            }
        }
        return max;
    }

    /**
     Дан массив nums = [3,2,2,3] и число val = 3.
     Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
     Таким образом, первые несколько (или все) элементов массива
     должны быть отличны от заданного, а остальные - равны ему.
     */
    public static void task4(){
        int[] arr = {3,2,2,3};
        int val = 3;
        System.out.println(Arrays.toString(ArrChangeToEnd(arr, val)));
    }
    public static int[] ArrChangeToEnd(int[] arr, int val){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == val) {
                temp = arr[i];
                arr[i]= arr[i+1];
                arr[i+1] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        HelloUser();
//        task3();
//        task4();
    }

}
