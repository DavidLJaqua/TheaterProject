/**
 * Project: OOAD_Project_1_Theater
 */

package Theater;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;



/** 
 * Theater class 
 *
 * @author Vanessa Esaw, David Jaqua, Franklin Ortega
 * Date: Feb 16, 2018
 */
class Theater implements Serializable {
    public static final long serialVersionUID = 1L;
    private ClientList clientList;
    private CustomerList customerList;
	private ShowList showList;
	private CreditCardList creditCardList;
    public static final int CLIENT_NOT_FOUND = 1;
    public static final int CLIENT_HAS_UPCOMING_SHOW = 2;
    public static final int CUSTOMER_NOT_FOUND = 3;
    public static final int CUSTOMER_HAS_ONE_CARD_ONLY = 4;
    public static final int ACTION_COMPLETED = 5;
    public static final int ACTION_FAILED = 6;
    private static Theater theater;

    /**
     * Private for the singleton pattern
     * Creates the client, show, and customer collection objects
     */
    private Theater() {
      clientList = ClientList.instance();
      showList = ShowList.instance();
      customerList = CustomerList.instance();
      creditCardList = CreditCardList.instance();
    }
    /**
     * Supports the singleton pattern
     * 
     * @return the singleton object
     */
    public static Theater instance() {
      if (theater == null) {
        CustomerIdServer.instance(); // instantiate all singletons
        return (theater = new Theater());
      } else {
        return theater;
      }
    }
    /**
     * Organizes the operations for adding a client
     * @param name client name
     * @param address client address
     * @param phone client phone
     * @return the Client object created
     */
    public Client addClient(String name, String address, String phone) {
      Client client = new Client(name, address, phone);
      if (clientList.insertClient(client)) {
        return (client);
      }
      return null;
    }
    /**
    * Organizes the operations for adding a show
    * @param name show name
    * @param clientID client id who owns the show
    * @param period time for the show to be played at the theater
    * @return the Show object created
    */
    public Show addShow(String name, String clientID, Calendar startDate, int period) {
        Show show = new Show(name, clientID, startDate, period);
        if (showList.insertShow(show)) {
          return (show);
        }
        return null;
    }
    
    /**
     * Organizes the operations for adding a customer
     * @param name customer name
     * @param address customer address
     * @param phone customer phone
     * @return the Customer object created
     */
     public Customer addCustomer(String name, String address, String phone,
                                     String creditCardNum, String expiryDate) {
         Customer customer = new Customer(name, address, phone,creditCardNum,expiryDate);
         if (customerList.insertCustomer(customer)) {
             return (customer);
         }
         return null;
     }
     
     /**
      * Organizes the operations for adding a credit card to an existing 
      * customer.
      * If credit card already has a owner (customer) then it can be added 
      * to the list. Message will be displayed.
      * 
      * @param customerID owner of the credit card
      * @param cardNumber card number
      * @param expiryDate expiration date of credit card
      * @return creditCard object if added to the CreditCard List, null otherwise.
      */
     public CreditCard addCreditCard(String customerID, String cardNumber, 
                                                         String expiryDate) {
         CreditCard creditCard = new CreditCard(customerID, cardNumber, expiryDate);
         if (creditCardList.insertCreditCard(creditCard)){
             return creditCard;
         }
         return null;
     }

    /**
     * Returns an iterator of client list
     * @return iterator to the collection
     */
    public Iterator getClient() {
        Iterator client = clientList.getClients();
        if (client == null) {
            return(null);
        } else {
            return (client);
        }
    }
    /**
     * Returns an iterator of customer list
     * @return iterator to the collection
     */
    public Iterator getCustomer() {
        Iterator customer = customerList.getCustomers();
        if (customer == null) {
            return(null);
        } else {
            return (customer);
        }
    }
    
    /**
     * Removes a specific client from the ClientList
     * @param clientId id of the client
     * @return a code representing the outcome
     */
    public int removeClient(String clientID) {
        Client client = clientList.search(clientID);
        if (client == null) {
            return(CLIENT_NOT_FOUND);
        }
        //if (client.hasUpcomingShow()) {     // Need to be implemented
        //	return(CLIENT_HAS_UPCOMING_SHOW);
        //}
        if (clientList.removeClient(clientID)) {
            return (ACTION_COMPLETED);
        }
        return (ACTION_FAILED);
    }/**
     * Removes a specific customer from the CustomerList
     * @param customertId id of the customer
     * @return a code representing the outcome
     */
    public int removeCustomer(String customerID) {
        Customer customer = customerList.search(customerID);
        if (customer == null) {
            return(CUSTOMER_NOT_FOUND);
        }
        if (customerList.removeCustomer(customerID)) {
            return (ACTION_COMPLETED);
        }
        return (ACTION_FAILED);
    }
    
    /**
     * Gets an iterator for the client list
     * @return Iterator of ClientList
     */
    public Iterator getClientList() {
    	return clientList.getClients();
    }
    
    /**
     * Gets an iterator for the customer list
     * @return Iterator of CustomerList
     */
    public Iterator getCustomerList() {
    	return customerList.getCustomers();
    }
    
    /**
     * Return list of shows
     * @return iterator to the collection 
     */
    public Iterator getShows(){
        Iterator shows = showList.getShowList();
        if (shows == null){
            return null;
        } else {
            return shows;
        }
    }

    /**
     * Retrieves a de-serialized version of the theater from disk
     * @return a Theater object
     */
    public static Theater retrieve() {
      try {
        FileInputStream file = new FileInputStream("TheaterData");
        ObjectInputStream input = new ObjectInputStream(file);
        input.readObject();
        ClientIDServer.retrieve(input);
        CustomerIdServer.retrieve(input); 
        return theater;
      } catch(IOException ioe) {
        ioe.printStackTrace();
        return null;
      } catch(ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
        return null;
      }
    }
    /**
     * Serializes the Theater object
     * @return true if the data could be saved
     */
    public static boolean storeData() {
        try {
            FileOutputStream file = new FileOutputStream("TheaterData");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(theater);
            output.writeObject(ClientIDServer.instance()); 
            output.writeObject(CustomerIdServer.instance());
            return true;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }
    /**
     * Writes the object to the output stream
     * @param output the stream to be written to
     */
    private void writeObject(java.io.ObjectOutputStream output) {
      try {
        output.defaultWriteObject();
        output.writeObject(theater);
      } catch(IOException ioe) {
        System.out.println(ioe);
      }
    }
    /**
     * Reads the object from a given stream
     * @param input the stream to be read
     */
    private void readObject(java.io.ObjectInputStream input) {
      try {
        input.defaultReadObject();
        if (theater == null) {
          theater = (Theater) input.readObject();
        } else {
          input.readObject();
        }
      } catch(IOException ioe) {
        ioe.printStackTrace();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    /** 
     * String form of the theater
     * 
     */
    @Override
    public String toString() {
        return "Theater{" + "clientList=" + clientList + '}';
    }


} // End of class Theater