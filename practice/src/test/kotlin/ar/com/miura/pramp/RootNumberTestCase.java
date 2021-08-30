package ar.com.miura.pramp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RootNumberTestCase {

    @Test
    public void shouldFindSolution() {
        assertEquals(2.0, RootOfNumber.root(4.0,2));
        assertEquals(3.000091552734375, RootOfNumber.root(27.0,3));
        assertEquals(2.0, RootOfNumber.root(16.0,4));
        assertEquals(1.73291015625, RootOfNumber.root(3.0,2));
        assertEquals(2.154541015625, RootOfNumber.root(10.0,3));
        assertEquals(5.4288482666015625, RootOfNumber.root(160.0,3));
    }

}
