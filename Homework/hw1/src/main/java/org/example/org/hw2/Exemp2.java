package org.hw2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Logger;
import org.json.JSONArray;

public class Exemp2 {
    private static Logger logger = Logger.getLogger(Exemp2.class.getName());
    public static void main(String[] args) {
        sqlRequest();
        Sorting();
        derivationGrades();
    }

    /**Дана строка sql-запроса "select * from students where ".
     * Сформируйте часть WHERE этого запроса, используя StringBuilder.
     * Данные для фильтрации приведены ниже в виде json строки.
     * Если значение null, то параметр не должен попадать в запрос.
     * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}*/

    private static void sqlRequest(){

        String json = "name:Ivanov, country:Russia, city:Moscow, age:null";
        
        String[] s1 = json.split(", ");
        StringBuilder request = new StringBuilder("SELECT * FROM students WHERE");

        for (int i = 0; i < s1.length; i++) {
            String [] parametr = s1[i].split(":");
            String key = parametr[0];
            String value = parametr[1];

            if (!value.equals("null")) {
                if (i!=0) {
                    request.append(" and");
                }
                request.append(" ").append(key).append(" = ").append(value);
            }
        }
        System.out.println(Arrays.toString(s1));
        System.out.println(request);
    }

    /**Реализуйте алгоритм сортировки пузырьком числового массива,
     * результат после каждой итерации запишите в лог-файл.*/
    private static void Sorting(){
        int[] arr = createArray();
        arr = bubbleSort(arr);
        printArray(arr);
    }
    private static int[] createArray(){
        int size = 10;
        int[] array = new int[size];
        System.out.print("Сформированный массив: ");
        for (int i=0; i<array.length; i++){
            array[i] = 10 + (int) (Math.random() * 99);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }
    private static void printArray(int[] array){
        System.out.print("Результат: ");
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    private static int[] bubbleSort(int[] arr){
        try (PrintWriter out = new PrintWriter("log-bubbleSort.txt")){
            int temp =0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < arr.length-i; j++) {
                    if (arr[j-1]>arr[j]){
                        temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
                out.println(Arrays.toString((arr)));
            }
            logger.info("Содержимое текущих папок записано в файл log-bubbleSort.txt");
        } catch (FileNotFoundException e) {
            logger.info(e.getMessage());
        }
        return arr;
    }

   /** Дана json строка (можно сохранить в файл и читать из файла)
    * (Коллеги, если сложно будет распарсить .json -> можно работать как со строкой обычной)
    * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

    Пример вывода:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.*/

   public static void derivationGrades()
   {
       JSONArray students = new JSONArray("[" +
               "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
               "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
               "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
       for (int i = 0; i < students.length(); i++)
       {
           String name = (String) students.getJSONObject(i).get("фамилия");
           String grade = (String) students.getJSONObject(i).get("оценка");
           String subject = (String) students.getJSONObject(i).get("предмет");
           System.out.printf("Студент %s получил %s по предмету %s\n", name, grade, subject);
       }
   }
}
