package lists;

import java.util.Arrays;
import java.util.List;

public class View extends AppService {

    public static void main(String[] args) {
        AppService appService = new AppService();
        List<Integer> listFirst = Arrays.asList(23, 17, 2, -4, 98, 512);
        List<Integer> listSecond = Arrays.asList(723, 915, -1200, -123, 97, 514, 230);

        System.out.println("Среднее значение первого списка чисел равно: "
                + appService.findTheAverageOfAList(listFirst));

        System.out.println("Среднее значение первого списка чисел равно: "
                + appService.findTheAverageOfAList(listSecond));

        appService.compareValues(appService.findTheAverageOfAList(listFirst),
                appService.findTheAverageOfAList(listSecond));

    }

}
