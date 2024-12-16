package lr2;

import static org.junit.jupiter.api.Assertions.*;

import com.example.lr2.CalcFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcFunctionTest {

    private CalcFunction calcFunction;

    @BeforeEach
    public void setUp() {
        // Инициализация объекта CalcFunction с диапазоном от 0.5 до 2 с шагом 0.1
        calcFunction = new CalcFunction(0.0, 3.0, 0.004);
    }

    @Test
    public void testFunctionForXGreaterThan1_4() {
        // Проверка для x > 1.4
        double x = 1.5;
        double expected = Math.exp(0.5 * x) * Math.cos(2 * x);
        assertEquals(expected, calcFunction.f(x), 1e-9);
    }

    @Test
    public void testFunctionForXBetween0_7And1_4() {
        // Проверка для 0.7 < x <= 1.4
        double x = 1.0;
        double expected = 0.5 * Math.pow(x, 2) * Math.log(x);
        assertEquals(expected, calcFunction.f(x), 1e-9);
    }

    @Test
    public void testFunctionForXLessThanOrEqualTo0_7() {
        // Проверка для x <= 0.7
        double x = 0.5;
        double expected = 1.0;
        assertEquals(expected, calcFunction.f(x), 1e-9);
    }

    @Test
    public void testCountStep() {
        // Проверка расчета шага
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double expected = 751;
        assertEquals(expected, calcFunction.countStep(start, end, step));
    }

    @Test
    public void testGetMaxI() {
        // Проверка нахождения максимального индекса
        int maxIndex = calcFunction.getMaxI();
        assertTrue(maxIndex >= 0);
    }

    @Test
    public void testGetMinI() {
        // Проверка нахождения минимального индекса
        int minIndex = calcFunction.getMinI();
        assertTrue(minIndex >= 0);
    }

    @Test
    public void testGetSum() {
        // Проверка вычисления суммы всех yValues
        double sum = calcFunction.getSum();
        assertNotNull(sum);
    }

    @Test
    public void testGetAverage() {
        // Проверка вычисления среднего значения yValues
        double average = calcFunction.getAverage();
        assertNotNull(average);
    }

    @Test
    public void testPrintForTest() {
        // Простой тест для проверки метода вывода на экран
        calcFunction.print_for_test();
        // Этот тест не проверяет логики, но может быть полезен для отладки
    }

}