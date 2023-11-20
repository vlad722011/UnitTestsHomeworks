package lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class NumbersListTest {
    /**
     *   Test for class numberList:
     *   class numbersList -> numbersList(int, List)}
     *   class numbersList -> setNumbersList(List)
     *   class numbersList -> setSize(int)
     *   class numbersList -> getNumbersList()
     *   class numbersList -> getSize()
     */
    @Test
    void testConstructor() {
        ArrayList<Integer> numbersList = new ArrayList<>();
        NumbersList actualNumbersList = new NumbersList(3, numbersList);
        ArrayList<Integer> numbersList2 = new ArrayList<>();
        actualNumbersList.setNumbersList(numbersList2);
        actualNumbersList.setSize(3);
        List<Integer> actualNumbersList2 = actualNumbersList.getNumbersList();
        assertEquals(3, actualNumbersList.getSize());
        assertEquals(numbersList, actualNumbersList2);
        assertSame(numbersList2, actualNumbersList2);
    }
}
