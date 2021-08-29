package ar.com.miura.pramp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecryptMessageTestCase {

    @Test
    public void shouldFindPairs() {
        String original = "dnotq";
        assertEquals("crime", ar.com.miura.pramp.DecryptMessage.decrypt(original));

    }
}
