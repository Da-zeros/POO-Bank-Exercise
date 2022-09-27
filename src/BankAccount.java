import java.util.ArrayList;
import java.util.Random;

public class BankAccount {
	
	int accountNumber, balance;
	
	public BankAccount(ArrayList<Integer> bankAccountListDB) {
		balance = 0;
		accountNumber = getUnicRandomNumber(bankAccountListDB);
	};
	
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
