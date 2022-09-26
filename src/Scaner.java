import java.util.Scanner;

public class Scaner {
	
	 Scanner sc = new Scanner(System.in);
	 
	 public String askForOption() {
		 
		System.out.println("Select a numeric option between [1 - 4]\n\n[1].Create new Client\n[2].Delete client\n[3].Create account");
		String name = sc.nextLine();
		 
		return name; 
	 }
	 
	 public void errorOption() {
		 
		 System.out.println("Option out of range");
	 }
	 
	 public String askClientName(){
		 
		 System.out.println("Introduce Client name:");
		 String name = sc.nextLine();
		 return name;
	 }
	 
	 public String askClientSurname(){
		 
		 System.out.println("Introduce Client surname:");
		 String surName = sc.nextLine();
		 return surName;
	 }
	 
	 public void nonExistentUserMsn() {
		 System.out.println("This user Doesn't exist");
	 }
	 
	 
}
