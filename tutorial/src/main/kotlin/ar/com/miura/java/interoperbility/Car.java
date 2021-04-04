package ar.com.miura.java.interoperbility;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Car {

    public static int x = 5;

    private String color;
    private String model;
    private int year;
    private Object anObject;

    public void runRunnable(Runnable r) {
        new Thread(r).start();
    }

    public void demoMethod() {
        /**
         * Single method interface , we can use
         * lambdas
         */
        new Thread( () -> {
            System.out.println(" I am a thread");
        }).start();
    }

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public static String xString() {
        System.out.println(" This is x : " + (++x));
        return " x  : " + x;
    }

    public Object getAnObject() {
        return anObject;
    }

    public void setAnObject(Object anObject) {
        this.anObject = anObject;
    }

    public String getColor() {
        return color;
    }

    public void setColor(@NotNull  String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(@Nullable String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void varArgsMethod(String... strings) {
        for(String eachString:strings) {
            System.out.println(" The string is : "+ eachString);
        }
    }

    public void usesIntArray(int[] ints) {
        for(int i:ints) {
            System.out.println(" I see the value : " + i);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

}
