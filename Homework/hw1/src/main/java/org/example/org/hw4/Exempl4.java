package org.example.org.hw4;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Exempl4 {
    public static void main(String[] args) {
        LinkedList<Integer> list = createList();
        System.out.println("Исходный список: " + list);

        reversLinkedList(list);
        System.out.println("Перевернутый список: " + list);

        Scanner iScan = new Scanner(System.in);
        System.out.print("Введите число для добавления: ");
        int number = iScan.nextInt();
        iScan.close();
        enqueue(list,number);
        System.out.println("Список с добавленным значением: " + list);

        System.out.println("Первый элемент списка (с удалением): "+ dequeue(list) +
                "\nСписок после удаления первого значения: " + list);

        System.out.println("Первый элемент списка: "+ first(list));

    }
    private static LinkedList<Integer> createList(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }
    /** 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.*/
    private static void reversLinkedList(LinkedList<Integer> list){
        int size = list.size();
        int temp = 0;
        while (temp!= size-1){
            list.add(size-temp, list.getFirst());//Вставка элемента add(index, value)
            list.removeFirst();
            temp++;
        }
    }

     /** 2. Реализуйте очередь с помощью LinkedList со следующими методами:
      * enqueue() - помещает элемент в конец очереди,
      * dequeue() - возвращает первый элемент из очереди и удаляет его,
      * first() - возвращает первый элемент из очереди, не удаляя.
     */
     private static void enqueue (LinkedList<Integer> list, int value){
         list.addLast(value);
     }
     private static int first(LinkedList<Integer> list){
         int value = list.getFirst();
         return value;
     }
     private static int dequeue(LinkedList<Integer> list){
         int value = list.getFirst();
         list.removeFirst();
         return value;
     }
}
