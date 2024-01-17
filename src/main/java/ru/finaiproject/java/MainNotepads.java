package ru.finaiproject.java;

import java.security.KeyStore;
import java.util.*;

public class MainNotepads {
    public static void main(String[] args) {

        Set<NotePads> set = new HashSet<>();

        set.add(new NotePads("4", "256", "Asus", "черный"));
        set.add(new NotePads("4", "400", "Asus", "серый"));
        set.add(new NotePads("5", "550", "НР", "белый"));
        set.add(new NotePads("6", "500", "НР", "белый"));

        System.out.println(checkParams(getParams(),set));
    }

    public static Map<Integer,String> getParams(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию: \n" +
                "1 - оперативная память\n2 - объем жесткого диска\n3 - производитель\n4 - цвет");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите параметр для поиска: ");
        String param = scanner.nextLine();

        Map<Integer, String> map = new HashMap<>();
        map.put(choice, param);
        return map;
    }

    public static Set<NotePads> checkParams(Map<Integer,String> map,Set<NotePads> set) {
        Set<NotePads> result = new HashSet<>();

        for (NotePads note : set) {
            for (Map.Entry<Integer,String> maps: map.entrySet()) {
                int k = maps.getKey();
                switch (k) {
                    case 1:
                        if (note.getRam().equals(maps.getValue())) {
                            result.add(note);
                        }
                    case 2:
                        if (note.getHDCapacity().equals(maps.getValue())) {
                            result.add(note);
                        }

                    case 3:
                        if (note.getBrand().equals(maps.getValue())) {
                            result.add(note);
                        }

                    case 4:
                        if (note.getColor().equals(maps.getValue())) {
                            result.add(note);
                        }
                }
            }
        }

        if (result.isEmpty()){
            System.out.println("Неверные параметры для поиска");
        }

        return result;

    }
}


