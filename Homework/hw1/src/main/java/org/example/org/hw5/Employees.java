package org.hw5;

import javax.swing.text.Style;
import java.util.*;

public class Employees {
    /**
     * 2. Пусть дан список сотрудников:
     *    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
     *    Отсортировать по убыванию популярности.
     */
    public static void main(String[] args) {
        List<String> employeesList = addList();
        System.out.println("Список сотрудников: " + employeesList + "\n");

        List<String> employeesName = getName(employeesList);
        System.out.println("Список имен: " + employeesName + "\n");

        HashMap<String, Integer> res = numberRepetitions(employeesName);

        System.out.println("Список имен и их повторений: " + res + "\n");

        sortPopularity(res);
    }

    private static List<String> addList (){
        List<String> list = new ArrayList<>();
        list.add("Иван Иванов");
        list.add("Светлана Петрова");
        list.add("Кристина Белова");
        list.add("Анна Мусина");
        list.add("Анна Крутова");
        list.add("Иван Юрин");
        list.add("Петр Лыков");
        list.add("Павел Чернов");
        list.add("Петр Чернышов");
        list.add("Мария Федорова");
        list.add("Марина Светлова");
        list.add("Мария Савина");
        list.add("Мария Рыкова");
        list.add("Марина Лугова");
        list.add("Анна Владимирова");
        list.add("Иван Мечников");
        list.add("Петр Петин");
        list.add("Иван Ежов");
        return list;
    }

    private static List<String> getName (List<String> list){
        List<String> name = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String [] s = list.get(i).split(" ");
            name.add(s[0]);
        }
        return name;
    }

    private static HashMap<String, Integer> numberRepetitions(List<String> name){
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < name.size(); i++) {
            String n = name.get(i);
            if(result.containsKey(n)) {
                result.replace(n, result.get(n)+1);
            } else {
                result.put(n,1);
            }
        }
        return result;
    }
    private static void sortPopularity(HashMap<String, Integer> map){
        int tempValues;
        String tempKeys;
        ArrayList<Integer> sortValues = new ArrayList<Integer>(map.values());
        ArrayList<String> sortKeys = new ArrayList<String>(map.keySet());
        for (int i = 0; i < sortValues.size(); i++) {
            for (int j = 1; j < sortValues.size(); j++) {
                if (sortValues.get(j) > sortValues.get(j-1)) {
                    tempValues = sortValues.get(j-1);
                    sortValues.set((j-1),sortValues.get(j));
                    sortValues.set((j),tempValues);
                    tempKeys = sortKeys.get(j-1);
                    sortKeys.set((j-1),sortKeys.get(j));
                    sortKeys.set((j),tempKeys);
                }
            }
        }
        System.out.println("Сортировка по популярности: ");
        for (int i = 0; i < sortValues.size(); i++) {
            System.out.printf("%s (кол-во повторений: %d)\n", sortKeys.get(i), sortValues.get(i));
        }
    }
}
