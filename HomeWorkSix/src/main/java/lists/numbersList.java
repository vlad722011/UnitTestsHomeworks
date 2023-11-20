package lists;

import java.util.ArrayList;
import java.util.List;

public class numbersList {
   private int size;
   private List<Integer> numbersList;

    public numbersList(int size, List<Integer> numbersList) {
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
