import java.util.ArrayList;



public class App {

	public static void main(String[] args) {
		
		mainMenu();
	}
	
	public static void mainMenu() {
		
		Scaner scaner = new Scaner();
		ArrayList<Integer> bankAccountListDB = new ArrayList<Integer>();
		ArrayList<Client> clientsDB = new ArrayList<Client>();
		boolean programeRunnig = true;
		//Working as a dataBase.
	
		while ( programeRunnig ) {
			
			String choise = scaner.askForOption();
			
			
			switch (  choise ) {
			case "0":
				programeRunnig = false;
				break;
			case "1":
				addClientToDB(createClient( scaner.askClientName(), scaner.askClientSurname(), scaner), clientsDB); 
				break;
			case "2":
				delClientFromDB(scaner.askClientName(), clientsDB, scaner);
				break;
			case "3":
				createAccount(scaner.askClientName(), clientsDB, bankAccountListDB ,scaner);
				break;
			case "4":
				selectAccountToDeposit(scaner.askClientName(), clientsDB, scaner);
				break;
			case "5":
				 selectAccountToWidraw(scaner.askClientName(), clientsDB, scaner);
				break;
			default:
				scaner.errorOption();
				break;
			}
		}
	}
	
	public static Client createClient(String name, String surName, Scaner scaner) {
		
		Client newClient = new Client(name, surName);
		System.out.println(scaner.createdUser(newClient.getName()));
		return newClient;
	}
	
	public static void addClientToDB(Client client, ArrayList<Client> clientDB) {
		
		clientDB.add(client);
	}
	
	
	public static int checkIfExists(String name, ArrayList<Client> clientDB) {
		
		boolean clientExists = false;
		int index, arraySize, clientIndex;
		arraySize = clientDB.size();
		index = 0;
		
		//Doing a while to iterate throw the array list stooping the loop when the condition is done to avoid iterate unnecessary once the data is found 
		while(index < arraySize && !clientExists) {
			
			clientExists = (name.equals(clientDB.get(index).getName() ) ) ? true : false;

			index++;
		}
		clientIndex = ( clientExists ) ? index-1 : -1;
		
		return clientIndex; 
		
	}
	
	public static void delClientFromDB(String name, ArrayList<Client> clientDB, Scaner scaner) {
		
		if( checkIfExists(name, clientDB) != -1)clientDB.remove(checkIfExists(name, clientDB));
		else scaner.nonExistentUserMsn();
		
	}
	
	public static void createAccount(String name, ArrayList<Client> clientDB, ArrayList<Integer> bankAccountListDB ,Scaner scaner) {
		
		int index;
		index = checkIfExists(name, clientDB);
		if( index != -1) {
			BankAccount acount = new BankAccount(bankAccountListDB);
			clientDB.get(index).AddAcount(acount);
			System.out.println(scaner.createdAcount(acount.getAccountNumber())); 
			
		}
		else scaner.nonExistentUserMsn();
		
	}
	
	/*
	 * this function is repeated by changing the functions inside it, 
	 * to improve it you could find a way to pass the internal functions as arguments in order to simplify the two functions into one.
	 * */
	public static void selectAccountToDeposit(String name,  ArrayList<Client> clientDB, Scaner scaner) {
	
		Client client = null;
		
		int nameIndex, acountIndex = 0;
		
		nameIndex = checkIfExists(name, clientDB);
		
		if( nameIndex != -1) {
			
			client = clientDB.get(nameIndex);
			client.showAccounts(); 
			acountIndex = checkAccount(client, scaner.askAccountNumber());
			
			if(acountIndex != -1) {
				//How to pass this method as a parameter to dont duplicate the function ???
				depositMooney(acountIndex, client, scaner.askAmountMooney(), scaner);
				
			}else scaner.nonExistingACount();
		}
		else scaner.nonExistentUserMsn();
	}
	
	public static int  checkAccount(Client client, int account) {
		
		int index, arraySize, accountIndex;
		boolean accountExists = false;
		ArrayList<BankAccount> accounts; 
		
		arraySize = client.getAccounts().size();
		index = 0;
		
		while(index < arraySize && !accountExists) {
			accounts = client.getAccounts();
			accountExists = (accounts.get(index).getAccountNumber() == account) ? true : false;
			index++;
		}
		accountIndex = ( accountExists ) ? index-1 : -1;
		
		return accountIndex; 
		
		
	}
	
	public static void depositMooney(int index, Client client, int amount, Scaner scaner) {
		BankAccount account;
		account = client.getAccount(index);
		account.setPlusBalance(amount);
		System.out.println(account.toString());
		scaner.bufferClean();
		
	}
	
	/*
	 * this function is repeated by changing the functions inside it, 
	 * to improve it you could find a way to pass the internal functions as arguments in order to simplify the two functions into one.
	 * */
	public static void selectAccountToWidraw(String name,  ArrayList<Client> clientDB, Scaner scaner) {
		
		Client client = null;
		
		int nameIndex, acountIndex = 0;
		
		nameIndex = checkIfExists(name, clientDB);
		
		if( nameIndex != -1) {
			
			client = clientDB.get(nameIndex);
			client.showAccounts(); 
			acountIndex = checkAccount(client, scaner.askAccountNumber());
			
			if(acountIndex != -1) {
				//How to pass this method as a parameter to dont duplicate the function ???
				withdrawMoney(acountIndex, client, scaner.askAmountMooneyToWithdraw(), scaner);
				
			}else scaner.nonExistingACount();
		}
		else scaner.nonExistentUserMsn();
	}
	
	public static void withdrawMoney(int index, Client client, int amount, Scaner scaner) {
		BankAccount account;
		account = client.getAccount(index);
		account.setMinusBalance(amount);
		System.out.println(account.toString());
		scaner.bufferClean();
	}
	

}
