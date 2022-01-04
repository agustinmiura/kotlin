package ar.com.miura.jvm.string.dp;



public class PalindromeTestCase {

    @org.junit.jupiter.api.Test
    public void shouldFind() {
        org.junit.jupiter.api.Assertions.assertEquals(3, new ar.com.miura.jvm.string.Palindrome().longestPalindrome("babad"));
    }

}
