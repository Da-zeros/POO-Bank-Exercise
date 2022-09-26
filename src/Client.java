import java.util.ArrayList;

public class Client {
	
	private String name, surName;
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public void AddAcount(BankAccount bankAcount) {
		accounts.add(bankAcount);
	}

	
	
	
	
	
}
