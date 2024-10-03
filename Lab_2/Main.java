import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInputProcessing inputProcessing = new UserInputProcessing();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введiть суму для оплати: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        PaymentType paymentType = inputProcessing.chosePaymentType();
        if (paymentType == null) {
            System.out.println("Невірний вибір типу оплати.");
            return;
        }


        Payment payment = inputProcessing.getPaymentDetails(paymentType, amount);

        if (inputProcessing.isCorrectPayment(payment)) {
            System.out.println("Платіж оброблено успішно.");
        } else {
            System.out.println("Платіж відхилено. Будь ласка, спробуйте ще раз.");
        }
    }
}
