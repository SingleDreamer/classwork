public class BankAccount {
    private double balance, interestRate;
    private String name;
    private int acctnumber;

    public BankAccount(String name, double balance) {
	this.name = name;
	this.balance=balance;
	interestRate = 0.3;
	acctnumber = 0;
    }

    public void deposit(int amt) {
	double damt = (double)(amt);
	balance = balance + damt;
    }

    public void withdraw(int amt) {
	double damt = (double)(amt);
	if (damt > balance)
	    System.out.println("You dont got da cash");
	else
	    balance = balance - damt;
    }

    public double getBalance() {
	return balance;
    }

    public void takeMoneyFrom(BankAccount other, int amt) {
	double damt = (double)(amt);
	if (damt > other.balance)
	    System.out.println("they dont got da cash");
	else {
	    other.withdraw(amt);
	    balance = balance + damt;
	}
    }

    public void giveMoneyTo(BankAccount other, int amt) {
	double damt = (double)(amt);
	if (amt > balance)
	    System.out.println("you dont got da cash");
	else {
	    balance = balance - damt;
	    other.deposit(amt);
	}
    }
}

