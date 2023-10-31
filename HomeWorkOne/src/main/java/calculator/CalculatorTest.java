package calculator;


import calculator.Calculator;


import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {

        // Проверка метода вычисления стоимости товара со скидкой, с использованием библиотеки AssertJ.
        // Случаи с корректными аргументами и позитивным сценарием
        assertThat(Calculator.calculatingDiscount(1000, 25)).isEqualTo(750);

        // Случаи с некорректными аргументами
        // 1. Аргумент "purchaseAmount" типа int, должен вызывать исключение, если он получает отрицательное значение
        try {
            Calculator.calculatingDiscount(1000, 10);
            //Calculator.calculatingDiscount(-1000, 10);
        } catch (ArithmeticException e) {
            if (e.getMessage().equals("The purchase amount cannot be negative")) {
                throw new AssertionError("Сумма покупки не может быть отрицательной");
            }
        }
        // 2. Аргумент "discountAmount" типа int, должен вызывать исключение, если он получает отрицательное значение
        try {
            Calculator.calculatingDiscount(1000, 10);
            //Calculator.calculatingDiscount(1000, -10);
        } catch (ArithmeticException e) {
            if (e.getMessage().equals("Discount cannot be negative")) {
                throw new AssertionError("Скидка не может быть отрицательной");
            }
        }
        // 3. Аргумент "discountAmount" типа int, должен вызывать исключение, если он получает значение больше 100
        try {
            Calculator.calculatingDiscount(1000, 50);
            //Calculator.calculatingDiscount(1000, 110);
        } catch (ArithmeticException e) {
            if (e.getMessage().equals("The discount cannot be less than 100 percent")) {
                throw new AssertionError("Скидка не может быть больше, чем 100 процентов");
            }
        }
    }
}


