import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenOddNumberTest {

    static EvenOddNumber number = new EvenOddNumber();
    public static int n = 0;
    public static boolean isInterval;
    public static boolean isEven;
    public static boolean isOdd;

    @BeforeAll
    public static void setup() {
        System.out.println("_____________________________________________________________________");
        Random rn = new Random();
        number.setN(rn.nextInt(101));
        n = number.getN();
        System.out.println(n + " : -> input number for tests");
        System.out.println("_____________________________________________________________________");

        isInterval = number.numberInInterval(n);
        System.out.println("the number is in the range [25 - 100} - >> this is: " + isInterval);
        System.out.println("_____________________________________________________________________");

        isEven = number.evenOddNumber(n);
        isOdd = true;
    }

    @Test
    void isEvenOddNumber() {
        if (n % 2 == 0) {
            assertTrue(isEven);
            System.out.println(n + " -> number is even");
        } else if (n % 2 != 0) {
            assertTrue(isOdd);
            System.out.println(n + " -> number is odd");
        }
    }

    @Test
    void numberInInterval() {
        if (n >= 25 && n < 100) {
            assertTrue(isInterval);
            System.out.println("number in interval [25 - 100}");
        }
    }

    @Test
    void numberNotInInterval() {
        if (!(n >= 25 && n < 100)) {
            assertFalse(isInterval);
            System.out.println("the number does not belong to the interval [25 - 100}");
        }
    }
}


