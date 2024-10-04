import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentTypeSelector paymentTypeSelector = new PaymentTypeSelector();
        PaymentDetailsInputHandler inputHandler = new PaymentDetailsInputHandler();
        PaymentValidator validator = new PaymentValidator();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введiть суму для оплати: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // очищення буферу

        PaymentType paymentType = paymentTypeSelector.chosePaymentType();
        if (paymentType == null) {
            System.out.println("Невірний вибір типу оплати.");
            return;
        }

        Payment payment = inputHandler.getPaymentDetails(paymentType, amount);

        if (validator.isCorrectPayment(payment)) {
            System.out.println("Платіж оброблено успішно.");
        } else {
            System.out.println("Платіж відхилено. Будь ласка, спробуйте ще раз.");
        }
    }
}
