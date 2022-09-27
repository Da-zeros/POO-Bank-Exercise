import java.util.Scanner;

public class Scaner {
		String name ,surName;
		int amountOfMooney, accountNumber;
	 Scanner sc = new Scanner(System.in);
	 
	 public String askForOption() {
		 
		System.out.println("Select a numeric option between [1 - 4]\n\n[1].Create new Client\n[2].Delete client\n[3].Create account\n[4].Deposit money");
		name = sc.nextLine();
		 
		return name; 
	 }
	 
	 public void errorOption() {
		 
		 System.out.println("Option out of range");
	 }
	 
	 public String askClientName(){
		 
		 System.out.println("Introduce Client name:");
		 name = sc.nextLine();
		 return name;
	 }
	 
	 public String askClientSurname(){
		 
		 System.out.println("Introduce Client surname:");
		 surName = sc.nextLine();
		 return surName;
	 }
	 
	 public void nonExistentUserMsn() {
		 System.out.println("This user Doesn't exist");
	 }
	 
	 public int askAmountMooney() {
		 System.out.println("amount of money to be deposited");
		 amountOfMooney = sc.nextInt();
		 return amountOfMooney;
	 }
	 
	 public int askAccountNumber() {
		 System.out.println("Enter the account number");
		 accountNumber = sc.nextInt();
		 return accountNumber;
	 }
	 
}
