import java.util.ArrayList;
import java.util.Random;

public class BankAccount {
	
	int accountNumber, balance;
	ArrayList<Integer> accountNumberList = new ArrayList<Integer>();
	
	
	public BankAccount() {
		balance = 0;
		accountNumber = 1;
	};
	
	public int getUnicRandomNumber() {
	    
		Random random = new Random();
	    int randomNum, index, arraySize;
	    boolean randomIsUnique, numberAdded;
	 
	    numberAdded = false;
	    randomIsUnique = true;
	    randomNum = 0;
	    
	    arraySize = accountNumberList.size();
	    index = 0;
	    
	    while( !numberAdded ) {
	    	 
	    	randomNum = random.nextInt(9999 - 0) + 0;
	    	 
	    	 while( index < arraySize || !randomIsUnique ) {
	    		 
	    		 if( randomNum == accountNumberList.get(index) ) randomIsUnique = false;
	    		 else {
	    			 numberAdded = true;
	    		 }
	    		 index++;
	    	 }
	    }
	    accountNumberList.add(randomNum);
	    return randomNum;
	    
	}
}
