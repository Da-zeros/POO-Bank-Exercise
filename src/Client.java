import java.util.ArrayList;

public class Client {
	
	private String name, surName;
	
	//a customer can have several accounts 
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	
	public BankAccount getAccount(int acount) {
		return accounts.get(acount);
	}
	
	public Client(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}
	
	public void setAccounts(ArrayList<BankAccount> accounts) {
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	
	public void AddAcount(BankAccount bankAcount) {
		accounts.add(bankAcount);
	}
	public void showAccounts() {
		for (BankAccount bankAccount : accounts) {
			System.out.println("Available accounts");
			System.out.println(bankAccount.getAccountNumber());
		}
	}

	
	
	
	
	
}
