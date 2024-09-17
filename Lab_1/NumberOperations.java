import java.util.ArrayList;
import java.util.Arrays;

public class NumberOperations {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();

        list.addAll(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));

        list.add(0, 12);
        list.add(4, 61.4141);
        list.add(9, 123.951);

        System.out.println("Всі числа: " + list);
        System.out.println("");


        // ВИвід чисел у форматі цілих чисел

        System.out.print("Числа у форматі цілих чисел: [");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d", list.get(i).intValue());

            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        System.out.println("");

        // Вивід чисел у форматі чисел з плаваючою точкой з двума знаками після коми

        System.out.print("Числа у форматі чисел з плаваючою точкой: [");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%.2f", list.get(i).doubleValue());

            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        System.out.println("-");


        // Знаходимо добуток перших п'яти чисел
        double product = 1;

        for (int i=0; i < 5; i++) {
            product *= list.get(i).doubleValue();
        }

        System.out.printf("Добуток перших п'яти чисел: %.3f", product);

    }
}
