package ru.finaiproject.java;

import java.security.KeyStore;
import java.util.*;

public class MainNotepads {
    public static void main(String[] args) {

        Set<NotePads> set = new HashSet<>();

        set.add(new NotePads("4", "256", "Asus", "������"));
        set.add(new NotePads("4", "400", "Asus", "�����"));
        set.add(new NotePads("5", "550", "��", "�����"));
        set.add(new NotePads("6", "500", "��", "�����"));

        System.out.println(checkParams(getParams(),set));
    }

    public static Map<Integer,String> getParams(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� �����, ��������������� ������������ ��������: \n" +
                "1 - ����������� ������\n2 - ����� �������� �����\n3 - �������������\n4 - ����");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("������� �������� ��� ������: ");
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
            System.out.println("�������� ��������� ��� ������");
        }

        return result;

    }
}


