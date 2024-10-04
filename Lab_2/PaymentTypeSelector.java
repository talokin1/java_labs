import java.util.Map;
import java.util.Scanner;


public class PaymentTypeSelector {
    private Scanner scanner;

    public PaymentTypeSelector() {
        this.scanner = new Scanner(System.in);
    }

    private static final Map<Integer, PaymentType> paymentTypeMap = Map.of(
    1, PaymentType.CreditCard,
    2, PaymentType.PayPal,
    3, PaymentType.BankTransfer

    );

    public PaymentType chosePaymentType() {
        System.out.print("1. CreditCard\n2. PayPal\n3. BankTransfer\nОберiть тип оплати: ");
        int choiceOfPaymentType = scanner.nextInt();
        return paymentTypeMap.getOrDefault(choiceOfPaymentType, null);
    }

}


class PaymentDetailsInputHandler {
    private Scanner scanner;

    public PaymentDetailsInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getCreditCardInfo() {
        System.out.print("Введіть номер карти: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Термін дії (MM/YY): ");
        String expiryDate = scanner.nextLine();

        System.out.print("Введіть CVV: ");
        String cvv = scanner.nextLine();

        return new String[]{cardNumber, expiryDate, cvv};
    }

    public String[] getPayPalInfo() {
        System.out.print("Введіть email: ");
        String email = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        return new String[]{email, password};
    }

    public String[] getBankTransferInfo() {
        System.out.print("Введіть номер рахунку: ");
        String iban = scanner.nextLine();

        System.out.print("Введіть назву банку: ");
        String bankName = scanner.nextLine();

        return new String[]{iban, bankName};
    }


    public Payment getPaymentDetails(PaymentType paymentType, double amount) {
        String[] paymentInfo = getPaymentInfo(paymentType);
        return PaymentFactory.createPayment(paymentType, amount, paymentInfo);
    }


    private String[] getPaymentInfo(PaymentType paymentType) {
        switch (paymentType) {
            case CreditCard:
                return getCreditCardInfo();
            case PayPal:
                return getPayPalInfo();
            case BankTransfer:
                return getBankTransferInfo();
            default:
                throw new IllegalArgumentException("Невідомий тип оплати");
        }
    }
}
    
    



class PaymentValidator {
    private Scanner scanner;

    public PaymentValidator() {
        this.scanner = new Scanner(System.in);
    }

    public boolean isCorrectPayment(Payment payment) {
        payment.makePayment();
        System.out.print("Чи правильно введені дані? (y/n): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("y");
    }
}
