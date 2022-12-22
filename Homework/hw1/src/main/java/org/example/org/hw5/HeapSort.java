package org.hw5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HeapSort {
    /**
     * 3. Реализовать алгоритм пирамидальной сортировки (HeapSort).
     */
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int max;

    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("Исходный массив: " + Arrays.toString(array));
        sort(array);
        System.out.println("Отсортированный массив: " +Arrays.toString(array));
    }
    private static int[] createArray() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
    public static void buildHeap(int[] a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxHeap(a,i);
        }
    }
    public static void maxHeap(int[] a, int i){
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            max=left;
        }
        else{
            max=i;
        }

        if(right <= n && a[right] > a[max]){
            max=right;
        }
        if(max!=i){
            exchange(i, max);
            maxHeap(a, max);
        }
    }

    public static void exchange(int i, int j){
        int t = a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void sort(int[] a0){
        a = a0;
        buildHeap(a);

        for(int i=n;i>0;i--){
            exchange(0,i);
            n=n-1;
            maxHeap(a,0);
        }
    }
}
