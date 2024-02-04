import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {

    @Test
    public void PlusTest() {
        int a = 2;
        int b = 3;

        int c = a + b;

        assertEquals(5, c, "a + b");
    }
}
