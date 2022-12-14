package org.hw3;

import java.util.*;

public class Exempl3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = createArrayList();
        //System.out.println("Минимальное значение в списке: "+ getMin(arr));
        //System.out.println("Максимальное значение в списке: "+ getMax(arr));
        //System.out.println("Среднее значение: " + getAverage(arr));
        int end = arr.size()-1;
        mergeSort(arr, 0, end);
        System.out.println(Arrays.asList(arr));
        //System.out.println("Результат (удаление четных чисел): " + Arrays.asList(removeEvenNumbers(arr)));

    }

    private static List<Integer> createArrayList() {
        List<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(10);
            array.add(val);
        }
        System.out.println("Сформированный список: "+ Arrays.asList(array));
        return array;
    }

    /**Реализовать алгоритм сортировки слиянием*/

    /**Пусть дан произвольный список целых чисел, удалить из него четные числа*/
    private static List<Integer> removeEvenNumbers (List<Integer> arr){
        for (int i = 0; i < arr.size(); ) {
            if(arr.get(i)%2 == 0) {
                arr.remove(i);
            } else {
                i++;
            }
        }
        return arr;
    }

    /**Задан целочисленный список ArrayList.
     * Найти минимальное, максимальное и среднее из этого списка.*/
    private static Integer getMin (List<Integer> arr){
        int min = Collections.min(arr);
        return min;
    }
    private static Integer getMax (List<Integer> arr){
        int max = Collections.max(arr);
        return max;
    }
    private static double getAverage (List<Integer> arr){
        double sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return arr.size() > 0 ? sum / arr.size() : 0;
    }
}
