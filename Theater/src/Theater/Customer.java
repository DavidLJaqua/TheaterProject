package Theater;


/*
 *Author - Vanessa Esaw
 * */
import java.util.*;
import java.io.Serializable;
public final class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phoneNum;
    private String customerId;
    private CreditCardList creditCardList;
    private static final String CUSTOMER_STRING = "Cus";

    /*ToDo work on constructor*/
    /*Test GetId from customerIdServer*/
    /**
    * Author: Vanessa
    * Composing single Customer object
    * Note that it doesn't include id attribute
    * This is because it is composed via getId()
    * function from CustomerIdServer class
    * 
    * @param name name of the member
    * @param address address of the member
    * @param phone phone number of the member
     * @param cardNumber customer credit card number
     * @param expirationDate credit card expiration date
    */
    public  Customer(String name, String address, String phone,
                        String cardNumber, String expirationDate) {
        this.name = name;
        this.address = address;
        this.phoneNum = phone;
        customerId = CUSTOMER_STRING + (CustomerIdServer.instance()).getId();
        CreditCard creditCard = new CreditCard(customerId, cardNumber, expirationDate);
        /*
         * Create a new credit card list for this customer which their only credit card
         */
        creditCardList = new CreditCardList(creditCard);
    }

    public Iterator getCreditCardList() {
    		return creditCardList.getCreditCardList();
    }
    
    public boolean addCreditCard(CreditCard creditCard){
        return creditCardList.insertCreditCard(creditCard);
    }
    
    public int getNumberOfCards(){
    	Iterator iterator = creditCardList.getCreditCardList();
    	int count = 0;
    	while(iterator.hasNext()) {
    		count++;
    	}
        return count;
    }

    /*Getters*/
    public String getName() {
    	return name;
    }

    public String getAddress() {
    	return address;
    }

    public String getPhoneNum() {	
    	return phoneNum;
      }

    public String getCustomerId() {
    	return customerId;
    }
    
    /**
     * Gets the first credit card this customer has
     * @return Customer's first credit card
     */
    public CreditCard getCustomerCreditCard(){
        return (CreditCard) creditCardList.getCreditCardList().next();
    }

    /*Setters*/
    public void setName(String name) {
            this.name = name;  
    }

    public void setAddress(String address) {
            this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Customer[" + "name=" + name + ", address=" + address + 
                ", phoneNum=" + phoneNum +", customerId=" + customerId +
                ", creditCardList=" + creditCardList.toString() + "]";
    }
}