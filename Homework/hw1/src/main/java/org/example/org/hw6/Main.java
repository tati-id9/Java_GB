package org.hw6;

import java.util.*;

public class Main {
    /**
     * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
     * 2. Создать множество ноутбуков.
     * 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
     *  отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
     *  “Введите цифру, соответствующую необходимому критерию:
     *      1) - ОЗУ
     *      2) - Объем ЖД
     *      3) - Операционная система
     *      4) - Цвет …
     * 4. Далее нужно запросить минимальные значения для указанных критериев -
     * сохранить параметры фильтрации можно также в Map.
     * 5. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
     */
    public static void main(String[] args) {
        Set<Laptops> setLaptop = createLaptops();
        filterSelection(setLaptop);
    }

    private static Set<Laptops> createLaptops(){
        Laptops laptop = new Laptops("Honor", "MagicBook X14", "Windows 10 Home", "Intel Core", 8, 256);
        Laptops laptop1 = new Laptops("Honor", "MagicBook X15", "Windows 10 Home", "Intel Core", 8, 256);
        Laptops laptop2 = new Laptops("HP", "15s-eq1142ur", "без ОС", "AMD", 8, 256);
        Laptops laptop3 = new Laptops("HP", "15s-fq3008ur", "без ОС", "Intel Pentium Silver", 8, 256);
        Laptops laptop4 = new Laptops("HUAWEI", "MateBook D 15", "Windows 11 Home", "AMD", 16, 512);
        Laptops laptop5 = new Laptops("ASUS", "VivoBook 15X", "без ОС", "AMD", 16, 512);
        Laptops laptop6 = new Laptops("Acer", "Nitro 5", "без ОС", "Intel Core i3-1005G1 ", 16, 512);
        Laptops laptop7 = new Laptops("Acer", "Aspire 7", "Windows 10 Pro", "AMD", 16, 1000);

        Set<Laptops> setLaptop = new HashSet<>();
        setLaptop.add(laptop);
        setLaptop.add(laptop1);
        setLaptop.add(laptop2);
        setLaptop.add(laptop3);
        setLaptop.add(laptop4);
        setLaptop.add(laptop5);
        setLaptop.add(laptop6);
        setLaptop.add(laptop7);
        return setLaptop;
    }

    private static void filterSelection(Set<Laptops> laptops){
        Map<Integer,String> criterion = new HashMap<Integer, String>();
        criterion.put(1, "Производитель");
        criterion.put(2, "Операционная система");
        criterion.put(3, "Производитель процессора");
        criterion.put(4, "ОЗУ");
        criterion.put(5, "Объем ЖД");

        System.out.println("Выберите кретерий поиска и введите его номер:");
        System.out.println(criterion);
        Scanner iScan = new Scanner(System.in);
        int numberCriterion = iScan.nextInt();

        switch (numberCriterion){
            case 1:
                Map<Integer,String> searchTerm1 = new HashMap<Integer, String>();
                searchTerm1.put(1, "Honor");
                searchTerm1.put(2, "HP");
                searchTerm1.put(3, "HUAWEI");
                searchTerm1.put(4, "ASUS");
                searchTerm1.put(5, "Acer");
                searchTerm1.put(6, "Apple");
                searchTerm1.put(7, "Lenovo");
                searchByParameter(laptops, searchTerm1);
                break;
            case 2:
                Map<Integer,String> searchTerm2 = new HashMap<Integer, String>();
                searchTerm2.put(1, "без ОС");
                searchTerm2.put(2, "Windows 11 Home");
                searchTerm2.put(3, "Windows 11 Pro");
                searchTerm2.put(4, "Windows 10 Home");
                searchTerm2.put(5, "Windows 10 Pro");
                searchTerm2.put(6, "macOS");
                searchTerm2.put(7, "Linux");
                searchByParameter(laptops, searchTerm2);
                break;
            case 3:
                Map<Integer,String> searchTerm3 = new HashMap<Integer, String>();
                searchTerm3.put(1, "AMD");
                searchTerm3.put(2, "Intel");
                searchTerm3.put(3, "Apple");
                searchByParameter(laptops, searchTerm3);
                break;
            case 4:
                Map<Integer,Integer> searchTerm4 = new HashMap<Integer, Integer>();
                searchTerm4.put(1, 4);
                searchTerm4.put(2, 8);
                searchTerm4.put(3, 16);
                searchTerm4.put(4, 32);
                LinkedHashSet<Integer> ram = ramAvailable(laptops);
                String str1 = "ram=";
                searchByParameterRange(laptops, searchTerm4, ram, str1, criterion.get(4));
                break;
            case 5:
                Map<Integer,Integer> searchTerm5 = new HashMap<Integer, Integer>();
                searchTerm5.put(1, 128);
                searchTerm5.put(2, 256);
                searchTerm5.put(3, 512);
                searchTerm5.put(4, 1000);
                LinkedHashSet<Integer> hd = hdAvailable(laptops);
                String str2 = "hd=";
                searchByParameterRange(laptops, searchTerm5, hd, str2, criterion.get(5));
                break;
            default:
                System.out.println("Вы неверно ввели номер кретерия поиска");
                break;
        }
        iScan.close();
    }

    private static void filterLaptop (Set<Laptops> laptops, String parametr){
        Set<Laptops> result = new HashSet<>();
        for (var element: laptops) {
            String laptop = element.toString();
            if (laptop.contains(parametr)) {
                result.add(element);
            }
        }
        if (result.isEmpty()){
            System.out.println("По заданому критериию ноутбуки не найдены");
        }
        else {
            System.out.println(result);
        }
    }

    private static void searchByParameter(Set<Laptops> laptops, Map<Integer,String> search){
        System.out.println("Выберите кретерий поиска и введите его номер:");
        System.out.println(search);
        Scanner iScan = new Scanner(System.in);
        int numberCriterion = iScan.nextInt();
        iScan.close();
        if (search.containsKey(numberCriterion)) {
            filterLaptop(laptops, search.get(numberCriterion));
        }
        else {
            System.out.println("Вы ввели неправильный номер кретерия");
        }
    }

    private static LinkedHashSet<Integer> ramAvailable(Set<Laptops> laptops){
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for(Laptops lp: laptops){
            result.add(lp.getRam());
        }
        return result;
    }

    private static LinkedHashSet<Integer> hdAvailable(Set<Laptops> laptops){
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for(Laptops lp: laptops){
            result.add(lp.getHd());
        }
        return result;
    }

    private static void searchByParameterRange(Set<Laptops> laptops, Map<Integer,Integer> criterion, LinkedHashSet<Integer> setValue, String s, String searchName){
        System.out.println("Пойск по критерию: "+ searchName);
        Map<Integer,Integer> searchCriteria = new HashMap<Integer, Integer>();
        System.out.println("Введите минимальное значение: ");
        Scanner iScan = new Scanner(System.in);
        int minCriterion = iScan.nextInt();
        System.out.println("Введите максимальное значение: ");
        int maxCriterion = iScan.nextInt();
        iScan.close();
        int j=0;
        for (int i=1; i< criterion.size()+1; i++){
            if (criterion.get(i)>= minCriterion && criterion.get(i)<=maxCriterion && setValue.contains(criterion.get(i))){
                searchCriteria.put(j,criterion.get(i));
                j++;
            }
        }

        if (searchCriteria.isEmpty()){
            System.out.println("По заданым значениям нет ноутбуков");
        }
        else {
            for (int i = 0; i < searchCriteria.size(); i++) {
               s = s + searchCriteria.get(i);
                filterLaptop(laptops,s);
            }
        }

    }

}
