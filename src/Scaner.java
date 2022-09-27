import java.util.Scanner;
import java.text.MessageFormat;

//a test class to make the code cleaner, maybe by not needing class instances I can improve it by making it static.
public class Scaner {
		String name ,surName;
		int amountOfMooney, accountNumber;
		Scanner sc = new Scanner(System.in);
	 
	 public String askForOption() {
		 
		System.out.println("Select a numeric option between [1 - 4]\n\n[1].Create new Client\n[2].Delete client\n[3].Create account\n[4].Deposit money\n[5].Withdraw mooney");
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
	 
	 public String createdUser(String name){
		 String string;
		 string = MessageFormat.format("User {0} has been created.",name);
		 return string;
	 }
	 
	 public String createdAcount(int acount){
		 String string;
		 string = MessageFormat.format("Acount {0} has been created.",acount);
		 return string;
	 }
	 
	 public String askClientSurname(){
		 
		 System.out.println("Introduce Client surname:");
		 surName = sc.nextLine();
		 return surName;
	 }
	 
	 public void nonExistentUserMsn() {
		 System.out.println("This user Doesn't exist");
	 }
	 public void nonExistingACount() {
		 System.out.println("This acount Doesn't exist");
	 }
	 
	 public int askAmountMooney() {
		 System.out.println("amount of money to be deposited");
		 amountOfMooney = sc.nextInt();
		 return amountOfMooney;
	 }
	 
	 public int askAmountMooneyToWithdraw() {
		 System.out.println("amount of money to withdraw");
		 amountOfMooney = sc.nextInt();
		 return amountOfMooney;
	 }
	 
	 public int askAccountNumber() {
		 System.out.println("Enter the account number");
		 accountNumber = sc.nextInt();
		 return accountNumber;
	 }
	 
	 public void bufferClean() {
		 sc.nextLine(); //Netejar el buffer d’entrada
	 }
	 
	 public void amountError() {
		 System.out.println("Your balance, is less than the amount you are trying to withdraw.");
	 }
}
