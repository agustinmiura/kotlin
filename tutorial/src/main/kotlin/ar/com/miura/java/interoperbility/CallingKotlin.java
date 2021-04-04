package ar.com.miura.java.interoperbility;

import ar.com.miura.kotlin.interoperability.KotlinCar;
import ar.com.miura.kotlin.interoperability.KotlinCarKt;

public class CallingKotlin {

    public static void main(String[] args) {

        /**
         * We are accesing the instance object inside the KotlinCar
         */
        KotlinCar car = new KotlinCar("blue", "Ford", 2010);
        KotlinCar.Companion.carComp();
        //With Jvm static you can avoid calling the Companion object
        //@JvmField
        //And the compiler generates
        KotlinCar.carComp();
        boolean value = KotlinCar.isAuto;

        /**
         * Null safety
         * This will fail during runtime
         */
        //car.printMe(null);

        /**
         * The @Throws(IOException::class)
         * notifies the Kotlin compiler that
         * is throwing an exception
         */
        try {
            car.throwException();
        } catch(Exception e) {
            e.printStackTrace();
        }

        /**
         * Calling from Java a Kotlin optional object
         * isn't so good Java requires the two
         * The Jvm method has 2
         * @JvmOverloads generates all the methods
         */
        car.defaultArgs("args");
    }
}
