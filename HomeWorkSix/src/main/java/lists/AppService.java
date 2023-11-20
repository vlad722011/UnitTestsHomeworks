package lists;

import java.util.List;

public class AppService implements IExecutable {
    @Override
    public int findTheAverageOfAList(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        else {
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            return sum / list.size();
        }
    }

    @Override
    public String compareValues(int value1, int value2) {
        if (value1 > value2) {
            return "Первый список имеет большее среднее значение";
        } else if (value2 > value1) {
            return "Второй список имеет большее среднее значение";
        }
        else {
            return "Средние значения равны";
        }
    }
}
