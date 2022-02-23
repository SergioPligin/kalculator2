package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    static int last = 2000;
    static int numbers[] = {1, 4, 5, 9, 10};
    static String[] letters = {"I", "IV", "V", "IX", "X", "L", "C", "D", "M"};
    static String[] metod = {"+", "-", "*", "/"};

    public static void main(String[] args) throws Exception {
        System.out.println("Enter your Roman Numerals or Integer number:");
        Scanner cti = new Scanner(System.in);
        String strings = cti.nextLine();
        List<String> myList = new ArrayList<>(Arrays.asList(strings.split(" ")));
        System.out.println(myList);
        myList.removeIf(String::isEmpty);
        // System.out.println("всё хорошо  " + myList);
        if (myList.size() != 3) {
            throw new Exception("Вы должны ввести число действие и второе число");
        }
        boolean check = checkDeystvie(metod, myList.get(1));
        if (!check) {
            throw new Exception("вы неправильно ввели действие над числами");
        }
        String pattern = "(X|IX|IV|V?I{0,3})$";
        Pattern r = Pattern.compile(pattern);
        Matcher pervoe = r.matcher(myList.get(0));
        Matcher vtoroe = r.matcher(myList.get(2));
        try {
            if (pervoe.matches() && vtoroe.matches()) {
                System.out.println("Работаем с римскими");
                System.exit(0);
            } else if (checkArabic(myList.get(0)) && checkArabic(myList.get(2))
            ) {
                System.out.println("Работаем с арабскими");
                System.exit(0);
            }
            System.out.println("Числа могут быть от 1 до 10");
            //throw new Exception("Некоректный ввод данных");
        } catch (Exception e) {
            throw new Exception("Некоректный ввод данных");
        }
    }

    static boolean checkDeystvie(String[] metod, String wwod) {

        for (String s : Main.metod) {
            //System.out.println(s + myList.get(0) + myList.get(1) + myList.get(2));
            if (Objects.equals(s, wwod)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkArabic(String chislo) {
        int arab = Integer.parseInt(chislo);
        return arab > 0 && arab <= 10;
    }
}
