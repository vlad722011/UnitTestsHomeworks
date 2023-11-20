package lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppServiceTest {
    /**
     * Тест метода findTheAverageOfAList(List) для пустого списка.
     */
    @Test
    void testFindTheAverageOfAList() {
        AppService appService = new AppService();
        assertEquals(0, appService.findTheAverageOfAList(new ArrayList<>()));
    }

    /**
     * Тест метода findTheAverageOfAList(List) для не пустого списка.
     * Тест для случая, когда все числа списка равны 1.
     */
    @Test
    void testFindTheAverageOfAList2() {
        AppService appService = new AppService();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        assertEquals(1, appService.findTheAverageOfAList(list));
    }

    /**
     * Тест метода findTheAverageOfAList(List) для не пустого списка.
     * Тест для случая, когда среднее значение в диапазоне от (-бесконечности до бесконечности),
     * в случае когда не происходит округление среднего значения при его нахождении
     * (SumNumbersOfList/list.size() == 0)
     */
    @Test
    void testFindTheAverageOfAList3() {
        AppService appService = new AppService();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(12);

        assertEquals(7, appService.findTheAverageOfAList(list));
    }

    /**
     * Тест метода findTheAverageOfAList(List) для не пустого списка.
     * Тест для случая, когда среднее значение в диапазоне от (-бесконечности до бесконечности),
     * в случае когда происходит округление среднего значения при его нахождении
     * (SumNumbersOfList/list.size() != 0)
     */
    @Test
    void testFindTheAverageOfAList4() {
        AppService appService = new AppService();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(1, appService.findTheAverageOfAList(list));
    }

    /**
     * Тест метода compareValues(int, int)
     * Тест для случая, когда средние значения равны.
     */
    @Test
    void testCompareValues1() {
        AppService appService = new AppService();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(6);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        int value1 = appService.findTheAverageOfAList(list1);
        int value2 = appService.findTheAverageOfAList(list2);

        assertThat(appService.compareValues(value1,value2)).isEqualTo("Средние значения равны");
    }

    /**
     * Тест метода compareValues(int, int)
     * Тест для случая, когда средние значения равны.
     */
    @Test
    void testCompareValues2() {
        AppService appService = new AppService();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(10);
        list1.add(24);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        int value1 = appService.findTheAverageOfAList(list1);
        int value2 = appService.findTheAverageOfAList(list2);

        assertThat(appService.compareValues(value1,value2))
                .isEqualTo("Первый список имеет большее среднее значение");
    }

    /**
     * Тест метода compareValues(int, int)
     * Тест для случая, когда средние значения равны.
     */
    @Test
    void testCompareValues3() {
        AppService appService = new AppService();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(-2);
        list1.add(-102);
        list1.add(-24);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        int value1 = appService.findTheAverageOfAList(list1);
        int value2 = appService.findTheAverageOfAList(list2);

        assertThat(appService.compareValues(value1,value2))
                .isEqualTo("Второй список имеет большее среднее значение");
    }
    
}
