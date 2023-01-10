package org.hw6;

import java.util.HashSet;
import java.util.Set;

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
        createLaptops();
    }

    private static void createLaptops(){
        Laptops laptop = new Laptops("Honor", "MagicBook X14", "Windows 10 Home", "Intel Core", 8, 256);
        Laptops laptop1 = new Laptops("Honor", "MagicBook X15", "Windows 10 Home", "Intel Core", 8, 256);
        Laptops laptop2 = new Laptops("HP", "15s-eq1142ur", "без ОС", "AMD", 8, 256);
        Laptops laptop3 = new Laptops("HP", "15s-fq3008ur", "без ОС", "Intel Pentium Silver", 8, 256);
        Laptops laptop4 = new Laptops("HUAWEI", "MateBook D 15", "Windows 11 Home", "AMD", 16, 512);
        Laptops laptop5 = new Laptops("ASUS", "VivoBook 15X", "без ОС", "AMD", 16, 512);
        Laptops laptop6 = new Laptops("Acer", "Nitro 5", "без ОС", "Intel Core", 16, 512);
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

        System.out.println(setLaptop);
    }
}
