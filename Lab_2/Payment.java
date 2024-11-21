public abstract class Payment {
    protected double amount;

    public Payment(double amount){
        this.amount = amount;
    }

    public abstract void makePayment();
    public abstract String formatPaymentInfo();
}

class CreditCardPaymet extends Payment{
    final private String cardNumber;
    final private String expiryDate;
    final private String cvv;

    public CreditCardPaymet(double amount, String cardNumber, String expiryDate, String cvv){
        super(amount);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }


    public String getCardNumber(){
        return cardNumber;
    }

    public String getExpiryDate(){
        return expiryDate;
    }

    public String getCvv(){
        return cvv;
    }


    @Override
    public void makePayment(){
        System.out.println("Сплачено: " + amount + " грн. кредитної карти: " + cardNumber);
    }

    @Override
    public String formatPaymentInfo() {
        return String.format("Номер картки: %s, дійсна до: %s, CVV: %s", cardNumber, expiryDate, cvv);
    }
}


class PayPal extends Payment{
    final private String email;
    final private String password;

    public PayPal(double amount, String email, String password){
        super(amount);
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public void makePayment(){
        System.out.println("Сплачено: " + amount + "грн. через PayPal: " + email);
    }

    @Override
    public String formatPaymentInfo() {
        return String.format("PayPal Email: %s, Пароль: %s", email, password);
    }

}

class BankTransfer extends Payment{
    final private String bankAccount;
    final private String bankName;

    public  BankTransfer(double amount, String bankAccount, String bankName){
        super(amount);
        this.bankAccount = bankAccount;
        this.bankName = bankName;
    }

    public String getBankAccount(){
        return bankAccount;
    }

    public String getBankName(){
        return bankName;
    }

    @Override
    public void makePayment(){
        System.out.println("Сплачено: " + amount + "грн. через банк: " + bankName + " " + bankAccount);
    }

    @Override
    public String formatPaymentInfo() {
        return String.format("Номер рахунку: %s, Банк: %s", bankAccount, bankName);
    }
}


class PaymentFactory {
    public static Payment createPayment(PaymentType type, double amount, String... details) {
        switch (type) {
            case CreditCard:
                return new CreditCardPaymet(amount, details[0], details[1], details[2]);
            case PayPal:
                return new PayPal(amount, details[0], details[1]);
            case BankTransfer:
                return new BankTransfer(amount, details[0], details[1]);
            default:
                throw new IllegalArgumentException("Невідомий тип оплати");
        }
    }
}








