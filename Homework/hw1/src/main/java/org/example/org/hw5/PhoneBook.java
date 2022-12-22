package org.hw5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    /** 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
     что 1 человек может иметь несколько телефонов.*/
    public static void main(String[] args) {
        addPhone("Игорь", "78945568978");
        addPhone("Игорь", "968767");
        addPhone("Алена", "78954746675");
        addPhone("Олег", "897558841874");
        System.out.println(phoneBook);
        System.out.println("Операции: \n1. Добавить контакт. \n2. Найти телефон. \n3. Обновить контакт. \n4. Удалить контакт");
        System.out.println("Введите номер операции, которую необходимо выполнить");
        Scanner iScan = new Scanner(System.in);
        int n = iScan.nextInt();
        String name, number;

        switch (n){
            case 1:
                System.out.println("Введите имя контакта: ");
                name = iScan.next();
                System.out.println("Введите номер: ");
                number = iScan.next();
                addPhone(name, number);
                break;
            case 2:
                System.out.println("Введите имя контакта: ");
                name = iScan.next();
                findPhone(name);
                break;
            case 3:
                System.out.println("Введите имя контакта: ");
                name = iScan.next();
                System.out.println("Введите новый номер: ");
                number = iScan.next();
                updatePhone(name, number);
                break;
            case 4:
                System.out.println("Введите имя контакта: ");
                name = iScan.next();
                deletePhone(name);
                break;
            default:
                System.out.println("вы неверно ввели операции");
                break;
        }
        iScan.close();
        System.out.println(phoneBook);
    }

    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
    private static void addPhone (String name, String number) {
        if(phoneBook.containsKey(name)) {
            phoneBook.get(name).add(number);
        } else {
            ArrayList<String> values = new ArrayList<>();
            values.add(number);
            phoneBook.put(name,values);
        }
    }
    private static ArrayList<String> findPhone(String name) {
        if(phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return new ArrayList<String>();
    }
    private static void deletePhone(String name){
        phoneBook.remove(name);
        System.out.println("Данные удалены");
    }
    private static void updatePhone(String name, String value){
        ArrayList<String> number = new ArrayList<>();
        number.add(value);
        phoneBook.put(name, number);
        System.out.println("Данные обновлены");
    }
}
