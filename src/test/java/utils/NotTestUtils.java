package utils;

import java.time.LocalDate;

public class NotTestUtils {
    public static int fibonacci() {
        //Для проверки использовал следующий ряд 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, … , ∞
        int n = LocalDate.now().getDayOfMonth() + 1;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }


}
