package org.hw4;

import java.util.LinkedList;

public class Exempl4 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        reversLinkedList(list);

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
        System.out.println(list);
    }

     /** 2. Реализуйте очередь с помощью LinkedList со следующими методами:
      * enqueue() - помещает элемент в конец очереди,
      * dequeue() - возвращает первый элемент из очереди и удаляет его,
      * first() - возвращает первый элемент из очереди, не удаляя.
     * 3. В калькулятор добавьте возможность отменить последнюю операцию.
     */
}
