package ru.finaiproject.java;

import java.util.*;

public class MainNotepads {
    public static void main(String[] args) {

        Set<NotePads> set = new HashSet<>();

        set.add(new NotePads("8", "256", "Asus", "������"));
        set.add(new NotePads("8", "256", "Asus", "������"));
        set.add(new NotePads("16", "128", "Asus", "�����"));
        set.add(new NotePads("64", "512", "��", "�����"));
        set.add(new NotePads("32", "1000", "��", "�����"));

        System.out.println(checkParams(getParams(),set));
    }
    public static boolean stopChoice(){
        System.out.println("������� ��������� ������? (1 - ��/ 0 - ���)" );
        Scanner scanner = new Scanner(System.in);
        int answ = scanner.nextInt();
        return answ == 1;
    }
    public static Map<Integer,String> getParams(){

        Map<Integer, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        boolean b;
        do {
            System.out.println("������� �����, ��������������� ������������ �������� ������: \n" +
                    "1 - ����������� ������\n2 - ����� �������� �����\n3 - �������������\n4 - ����");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("������� �������� ��� ����������� �������� ���������� ��������: ");
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
            System.out.println("�������� ��������� ��� ������");
        }


        return result;

    }
}


