package org.hw3;

import java.util.*;

public class Exempl3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = createArrayList();
        System.out.println("Минимальное значение в списке: "+ getMin(arr));
        System.out.println("Максимальное значение в списке: "+ getMax(arr));
        System.out.println("Среднее значение: " + getAverage(arr));
        arrSort(arr, 0,arr.size()-1);
        System.out.println("Результат после сортировки: " + Arrays.asList(arr));
        System.out.println("Результат после удаления четных чисел: " + Arrays.asList(removeEvenNumbers(arr)));
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
    private static void arrSort(List<Integer> al, int beg, int end) {
        if (beg < end) {
            int m = beg + (end - beg) / 2;
            arrSort(al, beg, m);
            arrSort(al, m + 1, end);
            merge(al, beg, m, end);
        }
    }
    private static void merge(List<Integer> al, int beg, int mid, int end) {

        int leftSide = mid - beg + 1;
        int rightSide = end - mid;
        ArrayList array1 = new ArrayList(leftSide);
        ArrayList array2 = new ArrayList(rightSide);
        int L[] = new int[leftSide];
        int R[] = new int[rightSide];

        for (int i = 0; i < leftSide; ++i) {
            L[i] = al.get(beg + i);
        }
        for (int j = 0; j < rightSide; ++j) {
            R[j] = al.get(mid + 1 + j);
        }

        int i = 0, j = 0;

        int k = beg;

        while (i < leftSide && j < rightSide) {
            if (L[i] <= R[j]) {
                al.set(k, L[i]);
                i++;
            } else {
                al.set(k, R[j]);
                j++;
            }
            k++;
        }
        while (i < leftSide) {
            al.set(k, L[i]);
            i++;
            k++;
        }
        while (j < rightSide) {
            al.set(k, R[j]);
            j++;
            k++;
        }
    }

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
