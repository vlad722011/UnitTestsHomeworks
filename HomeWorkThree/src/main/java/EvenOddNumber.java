public class EvenOddNumber {
    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
    int n;
    boolean isInterval;
    boolean isEven;
    boolean isOdd;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            isEven = true;
            return isEven;
        } else {
            isEven = false;
        }
        return isEven;
    }


    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%
    public boolean numberInInterval(int n) {
        if ((n >= 25) && (n < 100)) {
            isInterval = true;
        } else {
            isInterval = false;
        }
        return isInterval;
    }

}
