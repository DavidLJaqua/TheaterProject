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
    private CreditCard creditCard;

    private String customerId;
    private static final String CUSTOMER_STRING = "Cus";
    private List creditCardList = new LinkedList();
    
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
        creditCard = new CreditCard(customerId, cardNumber, expirationDate);
    }


    /*ToDo implement getCreditCardList() : Iterator*/
    public Iterator getCreditCardList() {
            return (creditCardList.listIterator());
    }
    
    public boolean addCreditCard(CreditCard creditCard){
        return creditCardList.add(creditCard);
    }
    
    
    /*ToDo implement getNumberOfCards() : Integer*/
    public int getNumberOfCards(){
        int cardAmount = 0;
        return cardAmount;
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
    
    public CreditCard getCustomerCreditCard(){
        return this.creditCard;
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
                ", creditCardNumber=" + creditCard.getCardNum() + 
                "Expiration Date=" + creditCard.getExpDate() + ']';
    }



}