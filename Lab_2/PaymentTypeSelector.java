import java.util.Scanner;


public class PaymentTypeSelector {
    private Scanner scanner;

    public PaymentTypeSelector() {
        this.scanner = new Scanner(System.in);
    }

    public PaymentType chosePaymentType() {
        System.out.print("1. CreditCard\n2. PayPal\n3. BankTransfer\nОберіть тип оплати: ");
        int choiceOfPaymentType = scanner.nextInt();
        scanner.nextLine();
        switch (choiceOfPaymentType) {
            case 1:
                return PaymentType.CreditCard;
            case 2:
                return PaymentType.PayPal;
            case 3:
                return PaymentType.BankTransfer;
            default:
                System.out.println("Неправильний вибір");
                return null;
        }
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
        switch (paymentType) {
            case CreditCard:
                String[] creditCardInfo = getCreditCardInfo();
                return PaymentFactory.createPayment(paymentType, amount, creditCardInfo);
            case PayPal:
                String[] paypalInfo = getPayPalInfo();
                return PaymentFactory.createPayment(paymentType, amount, paypalInfo);
            case BankTransfer:
                String[] bankTransferInfo = getBankTransferInfo();
                return PaymentFactory.createPayment(paymentType, amount, bankTransferInfo);
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
