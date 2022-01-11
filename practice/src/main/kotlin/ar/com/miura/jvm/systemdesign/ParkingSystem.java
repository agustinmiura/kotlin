package ar.com.miura.jvm.systemdesign;

public class ParkingSystem {
    private static final int SMALL = 3;
    private static final int MEDIUM = 2;
    private static final int BIG = 1;

    private int big;
    private int medium;
    private int small;

    private int bigRemain;
    private int mediumRemain;
    private int smallRemain;

    public ParkingSystem(int big, int medium, int small) {

        this.big = big;
        this.medium = medium;
        this.small = small;

        this.bigRemain = big;
        this.mediumRemain = medium;
        this.smallRemain = small;

    }

    public boolean addCar(int carType) {

        if (carType==SMALL && smallRemain>=1) {
            smallRemain--;
            return true;

        } else if (carType==SMALL && smallRemain<=0) {
            return false;

        } else if (carType==MEDIUM && mediumRemain>=1) {
            mediumRemain--;
            return true;

        } else if (carType==MEDIUM && mediumRemain<=0) {
            return false;

        } else if (carType==BIG && bigRemain>=1) {
            bigRemain--;
            return true;

        } else if (carType==BIG && bigRemain<=0) {
            return false;

        } else {
            return false;

        }

    }
}
