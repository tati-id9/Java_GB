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
        task(setLaptop);
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
    private static void filterLaptop (Set<Laptops> laptops, String parametr){
        Set<Laptops> result = new HashSet<>();
        for (var element: laptops) {
            String laptop = element.toString();
            if (laptop.contains(parametr)) {
                result.add(element);
            }
        }
        if (result.isEmpty()){
            System.out.println("По заданым критериям ноутбуки не найдены");
        }
        else {
            System.out.println(result);
        }
    }

    private static void task(Set<Laptops> laptops){
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
                criterionProducer(laptops);
                break;
            case 2:
                criterionOS(laptops);
                break;
            case 3:
                criterionCUP(laptops);
                break;
            case 4:
                criterionRAM(laptops);
                break;
            case 5:
                criterionHD(laptops);
                break;
            default:
                System.out.println("Вы неверно ввели номер кретерия поиска");
                break;
        }
        iScan.close();
    }

    private static LinkedHashSet<String> presenceProducer(Set<Laptops> laptops){
        LinkedHashSet<String> result = new LinkedHashSet<>();
        for(Laptops lp: laptops){
            result.add(lp.getProducer());
        }
        return result;
    }
    private static void criterionProducer(Set<Laptops> laptops){
        LinkedHashSet<String> prod = presenceProducer(laptops);
        System.out.println("Введите название одного из доступных производителе " + prod);
        Scanner iScan = new Scanner(System.in);
        String str = iScan.next().toString();
        iScan.close();
        if (prod.contains(str)){
            filterLaptop(laptops,str);
        }
        else {
            System.out.println("Вы ввели производителя неверно");
        }
    }

    private static void criterionOS(Set<Laptops> laptops){
        Map<Integer,String> criterion = new HashMap<Integer, String>();
        criterion.put(1, "без ОС");
        criterion.put(2, "Windows 11 Home");
        criterion.put(3, "Windows 11 Pro");
        criterion.put(4, "Windows 10 Home");
        criterion.put(5, "Windows 10 Pro");
        criterion.put(6, "macOS");
        criterion.put(7, "Linux");

        System.out.println("Выберите кретерий поиска и введите его номер:");
        System.out.println(criterion);
        Scanner iScan = new Scanner(System.in);
        int numberCriterion = iScan.nextInt();
        iScan.close();
        if (criterion.containsKey(numberCriterion)) {
            filterLaptop(laptops, criterion.get(numberCriterion));
        }
        else {
            System.out.println("Вы ввели неправильный номер кретерия");
        }
    }

    private static void criterionCUP(Set<Laptops> laptops){
        Map<Integer,String> criterion = new HashMap<Integer, String>();
        criterion.put(1, "AMD");
        criterion.put(2, "Intel");
        criterion.put(3, "Apple");

        System.out.println("Выберите кретерий поиска и введите его номер:");
        System.out.println(criterion);
        Scanner iScan = new Scanner(System.in);
        int numberCriterion = iScan.nextInt();
        iScan.close();
        if (criterion.containsKey(numberCriterion)) {
            filterLaptop(laptops, criterion.get(numberCriterion));
        }
        else {
            System.out.println("Вы ввели неправильный номер кретерия");
        }
    }

    private static LinkedHashSet<Integer> presenceRAM(Set<Laptops> laptops){
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for(Laptops lp: laptops){
            result.add(lp.getRam());
        }
        return result;
    }
    private static void criterionRAM(Set<Laptops> laptops){
        Map<Integer,Integer> criterion = new HashMap<Integer, Integer>();
        criterion.put(1, 4);
        criterion.put(2, 8);
        criterion.put(3, 16);
        criterion.put(4, 32);

        LinkedHashSet<Integer> ram = presenceRAM(laptops);

        Map<Integer,Integer> searchCriteria = new HashMap<Integer, Integer>();
        System.out.println("Введите минимальное значение ОЗУ: ");
        Scanner iScan = new Scanner(System.in);
        int minCriterion = iScan.nextInt();
        System.out.println("Введите максимальное значение ОЗУ: ");
        int maxCriterion = iScan.nextInt();
        iScan.close();
        int j=0;
        for (int i=1; i< criterion.size()+1; i++){
            if (criterion.get(i)>= minCriterion && criterion.get(i)<=maxCriterion && ram.contains(criterion.get(i))){
                searchCriteria.put(j,criterion.get(i));
                j++;
            }
        }

        if (searchCriteria.isEmpty()){
            System.out.println("По заданым значениям нет нноутбуков");
        }
        else {
            for (int i = 0; i < searchCriteria.size(); i++) {
                String s = "ram=" + searchCriteria.get(i);
                filterLaptop(laptops,s);
            }
        }

    }

    private static LinkedHashSet<Integer> presenceHD(Set<Laptops> laptops){
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for(Laptops lp: laptops){
            result.add(lp.getHd());
        }
        return result;
    }
    private static void criterionHD(Set<Laptops> laptops){
        Map<Integer,Integer> criterion = new HashMap<Integer, Integer>();
        criterion.put(1, 128);
        criterion.put(2, 256);
        criterion.put(3, 512);
        criterion.put(4, 1000);

        LinkedHashSet<Integer> hd = presenceHD(laptops);

        Map<Integer,Integer> searchCriteria = new HashMap<Integer, Integer>();
        System.out.println("Введите минимальное значение объема накопителя: ");
        Scanner iScan = new Scanner(System.in);
        int minCriterion = iScan.nextInt();
        System.out.println("Введите максимальное значение объема накопителя: ");
        int maxCriterion = iScan.nextInt();
        iScan.close();
        int j=0;
        for (int i=1; i< criterion.size()+1; i++){
            if (criterion.get(i)>= minCriterion && criterion.get(i)<=maxCriterion && hd.contains(criterion.get(i))){
                searchCriteria.put(j,criterion.get(i));
                j++;
            }
        }

        if (searchCriteria.isEmpty()){
            System.out.println("По заданым значениям нет нноутбуков");
        }
        else {
            for (int i = 0; i < searchCriteria.size(); i++) {
                String s = "hd=" + searchCriteria.get(i);
                filterLaptop(laptops,s);
            }
        }

    }

}
