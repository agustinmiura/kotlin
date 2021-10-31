package ar.com.miura.pramp;

public class SentenceReverseTestCase {

    @org.junit.jupiter.api.Test
    public void shouldReverseWords() {
        char[] chars = new char[]{ 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
        char[] reversed = SentenceReverse.reverseWords(chars);
        org.junit.jupiter.api.Assertions.assertNotNull(reversed);
    }

}
