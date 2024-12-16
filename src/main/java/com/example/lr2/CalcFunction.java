package com.example.lr2;

import java.util.Arrays;

import java.text.DecimalFormat;

public class CalcFunction {
    private static double a = -0.5;
    private static double b = 2;

    double[] xValues;
    double[] yValues;

    public CalcFunction(double start, double end, double step) {
        fillArrays(start, end, step);
    }

    public double f(double x) {
        if (x > 1.4) {
            return Math.exp(a * x) * Math.cos(b * x);
        } else if (x > 0.7) {
            return a * Math.pow(x, 2) * Math.log(x);
        } else {
            return 1.0;
        }
    }

    // Метод для вычисления шага
    public double countStep(double start, double end, double step) {
        if (start == end) return 0;
        return Math.round((end - start) / step + 1);
    }

    // Метод для заполнения массивов
    public void fillArrays(double start, double end, double step) {
        int n = (int) countStep(start, end, step);
        xValues = new double[n];
        yValues = new double[n];

        // Используем DecimalFormat для точного форматирования чисел
        DecimalFormat df = new DecimalFormat("#.#########"); // 9 знаков после запятой

        int maxLength = Math.max(String.valueOf(start).length(), Math.max(String.valueOf(end).length(), String.valueOf(step).length()));
        int scale = (int) Math.pow(10, maxLength - 1);

        for (int i = 0; i < n; i++) {
            int b = (int) ((start + i * step) * scale);
            xValues[i] = (double) b / scale;

            // Форматируем значение и заменяем запятую на точку перед парсингом
            String formattedValue = df.format(f(xValues[i])).replace(",", ".");
            yValues[i] = Double.parseDouble(formattedValue);
        }
    }


    // Метод для нахождения максимального индекса
    public int getMaxI() {
        int maxI = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] > yValues[maxI]) maxI = i;
        }
        return maxI;
    }

    // Метод для нахождения минимального индекса
    public int getMinI() {
        int minI = 0;
        for (int i = 1; i < yValues.length; i++) {
            if (yValues[i] < yValues[minI]) minI = i;
        }
        return minI;
    }

    // Метод для вычисления суммы всех значений
    public double getSum() {
        return Arrays.stream(yValues).sum();
    }

    // Метод для вычисления среднего значения
    public double getAverage() {
        return getSum() / yValues.length;
    }

    // Метод для вывода данных (можно использовать для тестирования)
    public void print_for_test() {
        System.out.println("i\tx \t\ty");
        for (int i = 0; i < xValues.length; i++) {
            System.out.println(i + "\t" + xValues[i] + " \t" + yValues[i]);
        }
        System.out.println();
    }
}
