package Theater;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CreditCardList implements Serializable{
	private static final long serialVersionUID = 1L;
	private List creditCardList = new LinkedList();
	/*Singleton instance of the ClientList*/
	private static CreditCardList creditCardListInstance;
	
	/* Private constructor for singleton pattern*/
	//ToDo:Note - discrepancy  in definition of ClientList (Singleton) constructor
	//			  versus CustomerList constructor -- one is empty and other is not
	//			  which is correct?
	private CreditCardList () {
		//creditCardList = new LinkedList<CreditCard>();
	}
	
	/* 
	 * Supports the singleton pattern
	 * @return the singleton object
	 */
	public static CreditCardList  instance() {
		if (creditCardListInstance == null) {
	      return (creditCardListInstance = new CreditCardList());
	    } else {
	      return creditCardListInstance;
	    }
	  }
	
	/**
     * Search for a specific creditCard based on credit card number.
     * @param creditCardNum String used to search creditCard in the list.
     * @return creditCard object.
     */
    public CreditCard search(String creditCardNum){
        for(Iterator iterator = creditCardList.iterator(); iterator.hasNext();){
            CreditCard creditCard = (CreditCard) iterator.next();
            if (creditCard.getCardNum().equals(creditCardNum)) {
                return creditCard;
            }
        }
        return null; // card not found.
    }
    
    
    /*
     * Removes Credit card from list, based on credit card number to search through the list
     * Returns boolean true if card found and removed, else it returns false of card with
     * credit card number not found
     */
    public boolean removeCreditCard(String creditCardNum){
		for (Iterator iterator = creditCardList.iterator(); iterator.hasNext();){
			CreditCard creditCard = (CreditCard) iterator.next();
			if (creditCard.getCardNum().equals(creditCardNum)){
				// found the card with the specified card number, remove it from list
				creditCardList.remove(creditCard);
				return true;
			}
		}
		return false;
	}
    
    /*
     * Inserts credit card into credit card list 
     * gives true if operation works, else, returns false 
     */
    public boolean insertCreditCard(CreditCard creditCard){
		return creditCardList.add(creditCard);
	}
    
    
    
    
    /**
     * @return an iterator of the CreditCardList.
     */
    public Iterator getCreditCardList(){
        return creditCardList.iterator();
    }

	@Override
	public String toString() {
		return creditCardList.toString();
	}
	
    
    
	
}


