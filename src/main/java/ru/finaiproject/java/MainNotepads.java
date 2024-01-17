package ru.finaiproject.java;

import java.util.*;

public class MainNotepads {
    public static void main(String[] args) {

        Set<NotePads> set = new HashSet<>();

        set.add(new NotePads("8", "256", "Asus", "черный"));
        set.add(new NotePads("8", "256", "Asus", "черный"));
        set.add(new NotePads("16", "128", "Asus", "серый"));
        set.add(new NotePads("64", "512", "НР", "белый"));
        set.add(new NotePads("32", "1000", "НР", "белый"));

        System.out.println(checkParams(getParams(),set));
    }
    public static boolean stopChoice(){
        System.out.println("Вывести результат поиска? (1 - да/ 0 - нет)" );
        Scanner scanner = new Scanner(System.in);
        int answ = scanner.nextInt();
        return answ == 1;
    }
    public static Map<Integer,String> getParams(){

        Map<Integer, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        boolean b;
        do {
            System.out.println("Введите цифру, соответствующую необходимому критерию поиска: \n" +
                    "1 - оперативная память\n2 - объем жесткого диска\n3 - производитель\n4 - цвет");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Введите параметр или минимальное значение указанного критерия: ");
            String param = scanner.nextLine();

            map.put(choice, param);
            b = stopChoice();
        } while (!b);

        return map;
    }

    public static  Set<NotePads> checkParams(Map<Integer,String> map,Set<NotePads> set) {
        Set<NotePads> result = new HashSet<>();
//        Map <String,NotePads> nd = new HashMap<>();

        for (NotePads note : set) {
            for (Map.Entry<Integer,String> maps: map.entrySet()) {
                int k = maps.getKey();
                switch (k) {
                    case 1:
                        int i = Integer.parseInt(note.getRam());
                        int i2 = Integer.parseInt(maps.getValue());
                        if (i >= i2) {
                            result.add(note);
                        }
                    case 2:
                        int a = Integer.parseInt(note.getHDCapacity());
                        int a2 = Integer.parseInt(maps.getValue());
                        if (a >= a2) {
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


