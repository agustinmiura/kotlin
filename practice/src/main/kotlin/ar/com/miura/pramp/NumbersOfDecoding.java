package ar.com.miura.pramp;

public class NumbersOfDecoding {
    public int decodeVariations(String string) {
        return helper(string, 0);
    }

    private int helper(String data, int index) {

        if (index==data.length()) {
            return 1;
        }

        if (data.charAt(index)=='0') {
            return 0;
        }

        if (index==data.length()-1) {
            return 1;
        }

        int qty = helper(data, index+1);
        if (
            Integer.parseInt(data.substring(index, index+2))<=26
        ) {
            qty += helper(data, index+2);
        }

        return qty;
    }
}
