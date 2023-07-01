package DZ3;

/* Задача №2
По желанию
Вы разрабатываете систему банковских транзакций. Необходимо написать программу,
которая позволяет пользователям осуществлять переводы средств со своего банковского счета на другие счета.
Однако, в системе существуют некоторые ограничения и возможные ошибки, которые нужно обрабатывать.

Требования:

При переводе средств, сумма должна быть положительной и не превышать доступный баланс на счете.
Если сумма перевода отрицательная или равна нулю, выбрасывается исключение InvalidAmountException
с сообщением "Некорректная сумма перевода".
Если на балансе недостаточно средств для перевода, выбрасывается исключение InsufficientFundsException
с сообщением "Недостаточно средств на счете".
При успешном переводе, сумма должна списываться с текущего счета и зачисляться на целевой счет.
 */
public class Task2 {
    public static Transaction makeTransaction(BankAccount from, BankAccount to, double money) {
        System.out.print("Transaction: from '" + from.getName() + "' amount: " + money +
                "$ to '" + to.getName() + "' processing...   ");
        Transaction transaction = new Transaction(from, to, money);
        try {
            if (transaction.executeTransaction()) { // boolean executeTransaction() бросает ошибки
                System.out.print("<<Transaction complete!>>\n");
                return transaction;
            }
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.print("<<Failed!>>   " + e.getMessage());
        }
        return transaction;
    }

    public static void main(String[] args) {
        BankAccount peter = new BankAccount("Peter Capaldi", 2000.0);
        System.out.println(peter);
        BankAccount john = new BankAccount("John Doe");
        System.out.println(john);
        System.out.println();
        Transaction f1 = makeTransaction(peter, john, 567.0); // Examples
        Transaction f2 = makeTransaction(peter, john, 2000.0);
        Transaction f3 = makeTransaction(peter, john, -765.0);
        Transaction f4 = makeTransaction(peter, john, 0.0);
        Transaction f5 = makeTransaction(john, peter, 100.0);
        Transaction f6 = makeTransaction(john, peter, 567.0);
        System.out.println("\n" + peter); // Total balance
        System.out.println(john);
        System.out.println("\nResults:"); //results
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);
        System.out.println(f6);
    }
}

class BankAccount {
    String holderName;
    double money;

    BankAccount(String holderName) {
        this.holderName = holderName;
        this.money = 0;
    }

    BankAccount(String holderName, double money) {
        this.holderName = holderName;
        this.money = money;
    }

    public String getName() {
        return holderName;
    }

    public void setName(String holderName) {
        this.holderName = holderName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double money) {
        if (money > 0) {
            this.money += money;
        }
    }

    public void reduceMoney(double money) {
        if (money > 0 && money < this.money) {
            this.money -= money;
        }
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                "Holder Name is '" + holderName + '\'' +
                ", with balance: " + money + "$";
    }
}

class Transaction {
    private final BankAccount firstCustomer;
    private final BankAccount secondCustomer;
    private final double firstCustomerHaveMoney;
    private final double moneyQuantity;
    private boolean status;

    public Transaction(BankAccount from, BankAccount to, double moneyQuantity) {
        this.firstCustomer = from;
        this.secondCustomer = to;
        this.firstCustomerHaveMoney = firstCustomer.getMoney();
        this.moneyQuantity = moneyQuantity;
        this.status = false;
    }


    public boolean executeTransaction() throws InsufficientFundsException, InvalidAmountException {
        if (moneyQuantity <= 0) {
            throw new InvalidAmountException("Transfer amount is incorrect!\n");
        }
        if (moneyQuantity > firstCustomerHaveMoney) {
            throw new InsufficientFundsException(firstCustomer.getName() + " has not enough money!\n");
        }
        firstCustomer.reduceMoney(moneyQuantity);
        secondCustomer.addMoney(moneyQuantity);
        this.status = true;
        return true;
    }

    @Override
    public String toString() {
        if (status){
            return "Confirmed";
        }else return "Rejected";

    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}