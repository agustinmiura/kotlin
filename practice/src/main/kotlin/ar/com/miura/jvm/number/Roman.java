package ar.com.miura.jvm.number;


/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3667/
 */
public class Roman {

    public String intToRoman(int num) {
        if (num>=1&&num<=10) {
            return range10(num);

        } else if (num>=11 && num<=99) {
            return range99(num);

        } else if (num>=100 && num<=999) {
            return range999(num);

        } else if (num>=1000 && num<= 3999) {
            return range9999(num);

        } else {
            return null;

        }
    }

    private String range9999(Integer number) {
        int part1000 = number/1000;
        int remainder = (number % 1000);

        java.util.Map<Integer, String> map = new java.util.HashMap<>();

        map.put(1, "M");
        map.put(2, "MM");
        map.put(3, "MMM");

        String stringNumber = map.get(part1000);

        //3999

        if (remainder>=100 && remainder<=999) {
            return stringNumber = stringNumber + range999(remainder);

        } else if (remainder>=11 && remainder <= 99) {
            return stringNumber + range99(remainder);

        } else if (remainder>=1 && remainder<=10) {
            return stringNumber + range10(remainder);

        }


        return stringNumber;
    }

    private String range999(Integer number) {
        int part100 = number/100;
        int remainder = (number % 100);

        java.util.Map<Integer, String> map = new java.util.HashMap<Integer, String>();

        map.put(1, "C");
        map.put(2, "CC");
        map.put(3,"CCC");
        map.put(4,"CD");
        map.put(5, "D");
        map.put(6, "DC");
        map.put(7, "DCC");
        map.put(8, "DCCC");
        map.put(9, "CM");

        String numberString = map.get(part100);

        //999
        if (remainder==0) {
            return numberString;
        } else if (remainder>=1 && remainder<=10) {
            numberString = numberString + range10(remainder);
        } else {
            numberString = numberString + range99(remainder);
        }
        return numberString;
    }

    private String range99(Integer number) {
        int part10 = number/10;
        int remainder = (number % 10);

        java.util.Map<Integer, String> map = new java.util.HashMap<Integer, String>();
        map.put(1, "X");
        map.put(2, "XX");
        map.put(3, "XXX");
        map.put(4, "XL");
        map.put(5, "L");
        map.put(6, "LX");
        map.put(7, "LXX");
        map.put(8, "LXXX");
        map.put(9, "XC");

        String result = map.get(part10);
        if (remainder>=1) {
            result = result + range10(remainder);
        }
        return result;

    }

    private String range10(Integer number) {
        java.util.Map<Integer, String> map = new java.util.HashMap<Integer, String>();
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(6,"VI");
        map.put(7,"VII");
        map.put(8,"VIII");
        map.put(9,"IX");
        map.put(10,"X");
        return map.get(number);
    }
}
