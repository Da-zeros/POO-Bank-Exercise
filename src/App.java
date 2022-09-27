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
				addClientToDB(createClient( scaner.askClientName(), scaner.askClientSurname()), clientsDB); 
				for (Client client : clientsDB) {
					System.out.println(client);
				}
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
			default:
				scaner.errorOption();
				break;
			}
		}
	}
	
	public static Client createClient(String name, String surName) {
		
		Client newClient = new Client(name, surName);
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
		}
		else scaner.nonExistentUserMsn();
		
	}
	
	public static void selectAccountToDeposit(String name,  ArrayList<Client> clientDB, Scaner scaner) {
	
		Client client = null;
		BankAccount account;
		int nameIndex, acountIndex = 0;
		
		nameIndex = checkIfExists(name, clientDB);
		
		if( nameIndex != -1) {
			client = clientDB.get(nameIndex);
			client.showAccounts(); 
			acountIndex = checkAccount(client, scaner.askAccountNumber());
			
		}if(acountIndex != -1) {
			client.getAccount(acountIndex);
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
	
	public static void depositMooney(int index, ArrayList<Client> clientDB,int deposit, Scaner scaner) {
		
		
		
	}
	

}
