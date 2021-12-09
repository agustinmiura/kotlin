package ar.com.miura.pramp;

public class NumbersOfDecodingTestCase {

    private NumbersOfDecoding algorithm = new ar.com.miura.pramp.NumbersOfDecoding();

    @org.junit.jupiter.api.Test
    public void shouldOneDigit() {
        String input = "26";
        int numbers = algorithm.decodeVariations(input);
        org.junit.jupiter.api.Assertions.assertEquals(2, numbers);
    }

    @org.junit.jupiter.api.Test
    public void shouldDecodeZeroDigit() {
        String input = "06";
        int numbers = algorithm.decodeVariations(input);
        org.junit.jupiter.api.Assertions.assertEquals(0, numbers);
    }

    @org.junit.jupiter.api.Test
    public void shouldDecodeNumber() {
        String input = "1262";
        int numbers = algorithm.decodeVariations(input);
        org.junit.jupiter.api.Assertions.assertEquals(3, numbers);
    }

}
