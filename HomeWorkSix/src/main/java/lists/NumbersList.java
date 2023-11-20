package lists;

import java.util.List;

public class NumbersList {
   private int size;
   private List<Integer> numbersList;

    public NumbersList(int size, List<Integer> numbersList) {
        this.size = size;
        this.numbersList = numbersList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    public void setNumbersList(List<Integer> numbersList) {
        this.numbersList = numbersList;
    }
}
