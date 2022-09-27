import java.util.ArrayList;
import java.util.Random;
import java.text.MessageFormat;
public class BankAccount {
	
	int accountNumber, balance;
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setPlusBalance(int balance) {
		this.balance += balance;
	}
	
	public void setMinusBalance(int amount) {
		
		Scaner scaner = new Scaner();
		if(amount > balance) scaner.amountError();
		else this.balance-= amount;
	}

	public String toString() {
		
		return MessageFormat.format("Account balance {0}", balance);
		
	}

	public BankAccount(ArrayList<Integer> bankAccountListDB) {
		balance = 0;
		accountNumber = getUnicRandomNumber(bankAccountListDB);
	};
	
	 //function that generates a random number and compares it with the existing ones in a list (as a database) to avoid repeating them. 
	public int getUnicRandomNumber(ArrayList<Integer> bankAccountListDB) {
	    
		Random random = new Random();
	    int randomNum, index, arraySize;
	    boolean randomIsUnique, numberAdded;
	 
	    numberAdded = false;
	    randomIsUnique = true;
	    randomNum = 0;
	    
	    arraySize = bankAccountListDB.size();
	    index = 0;
	    
	    while( !numberAdded ) {
	    	 
	    	randomNum = random.nextInt(9999 - 0) + 0;
	    	 
	    	if(arraySize == 0) 	numberAdded = true;
	    	else {
	    		
	    		while(index < arraySize && randomIsUnique) {
		    		 
		    		 if( randomNum == bankAccountListDB.get(index) ) randomIsUnique = false;
		    		 index++;
		    	 }
	    		 numberAdded = (randomIsUnique)?true:false;
	    		 index = ( !randomIsUnique )? 0: index;
	    	}
	    	 
	    }
	    bankAccountListDB.add(randomNum);
	    return randomNum;
	    
	}
}
