package Theater;

/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import static Theater.Theater.CLIENT_NOT_FOUND;
import java.util.*;
import java.text.*;
import java.io.*;
/**
 * 
 * This class implements the user interface for the Library project.
 * The commands are encoded as integers using a number of
 * static final variables. A number of utility methods exist to
 * make it easier to parse the input.
 *
 */
public class UserInterface {
    private static UserInterface userInterface;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Theater theater;
    private static final int EXIT = 1;
    private static final int ADD_CLIENT = 2;
    private static final int REMOVE_CLIENT = 3;
    private static final int LIST_CLIENTS = 4;
    private static final int ADD_CUSTOMER = 5;
    private static final int REMOVE_CUSTOMER = 6;
    private static final int ADD_CREDIT_CARD = 7;
    private static final int REMOVE_CREDIT_CARD = 8;
    private static final int LIST_CUSTOMERS = 9;
    private static final int ADD_SHOW = 10;
    private static final int LIST_SHOWS = 11;
    private static final int STORE_DATA = 12;
    private static final int RETRIEVE_DATA = 13;
    private static final int HELP = 14;
    /**
     * Made private for singleton pattern.
     * Conditionally looks for any saved data. Otherwise, it gets
     * a singleton Theater object.
     */
    private UserInterface() {
      if (yesOrNo("Look for saved data and use it?")) {
        retrieveData();
      } else {
        theater = Theater.instance();
      }
    }
    /**
     * Supports the singleton pattern
     * 
     * @return the singleton object
     */
    public static UserInterface instance() {
      if (userInterface == null) {
        return userInterface = new UserInterface();
      } else {
        return userInterface;
      }
    }
    /**
     * Gets a token after prompting
     * 
     * @param prompt - whatever the user wants as prompt
     * @return - the token from the keyboard
     * 
     */
    public String getToken(String prompt) {
      do {
        try {
          System.out.println(prompt);
          String line = reader.readLine();
          StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
          if (tokenizer.hasMoreTokens()) {
            return tokenizer.nextToken();
          }
        } catch (IOException ioe) {
          System.exit(0);
        }
      } while (true);
    }
    /**
     * Queries for a yes or no and returns true for yes and false for no
     * 
     * @param prompt The string to be prepended to the yes/no prompt
     * @return true for yes and false for no
     * 
     */
    private boolean yesOrNo(String prompt) {
      String more = getToken(prompt + " (Y|y)[es] or anything else for no");
      return !(more.charAt(0) != 'y' && more.charAt(0) != 'Y');
    }
    /**
     * Converts the string to a number
     * @param prompt the string for prompting
     * @return the integer corresponding to the string
     * 
     */
    public int getNumber(String prompt) {
      do {
        try {
          String item = getToken(prompt);
          Integer number = Integer.valueOf(item);
          return number.intValue();
        } catch (NumberFormatException nfe) {
          System.out.println("Please input a number ");
        }
      } while (true);
    }
    /**
     * Prompts for a date and gets a date object
     * @param prompt the prompt
     * @return the data as a Calendar object
     */
    public Calendar getDate(String prompt) {
      do {
        try {
          Calendar date = new GregorianCalendar();
          String item = getToken(prompt);
          DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
          date.setTime(dateFormat.parse(item));
          return date;
        } catch (Exception fe) {
          System.out.println("Please input a date as mm/dd/yy");
        }
      } while (true);
    }
    /**
     * Prompts for a command from the keyboard
     * 
     * @return a valid command
     * 
     */
    public int getCommand() {
      do {
        try {
          int value = Integer.parseInt(getToken("Enter command: "));
          if (value >= EXIT && value <= HELP) {
            return value;
          }
        } catch (NumberFormatException nfe) {
          System.out.println("Enter a number");
        }
      } while (true);
    }
    /**
     * Displays the help screen
     * 
     */
    public void help() {
      System.out.println("Enter a number between 1 and 14 as explained below:");
      System.out.println(EXIT + " to Exit");
      System.out.println(ADD_CLIENT + " to add a client");
      System.out.println(REMOVE_CLIENT + " to remove client");
      System.out.println(LIST_CLIENTS + " to list all clients");
      System.out.println(ADD_CUSTOMER + " to add a customer");
      System.out.println(REMOVE_CUSTOMER + " to remove a customer");
      System.out.println(ADD_CREDIT_CARD + " to add a credit card");
      System.out.println(REMOVE_CREDIT_CARD + " to remove a credit card");
      System.out.println(LIST_CUSTOMERS + " to list all customers");
      System.out.println(ADD_SHOW + " to add a show/play");
      System.out.println(LIST_SHOWS + " to list all shows");
      System.out.println(STORE_DATA + " to  save data");
      System.out.println(RETRIEVE_DATA + " to retrieve data");
      System.out.println(HELP + " for help");
    }
    /**
     * Method to be called for adding a client.
     * Prompts the user for the appropriate values and
     * uses the appropriate Theater method for adding the client.
     *  
     */
    public void addClient() {
        String name = getToken("Enter client name");
        String address = getToken("Enter address");
        String phone = getToken("Enter phone");
        Client result;
        result = theater.addClient(name, address, phone);
        if (result == null) {
            System.out.println("Could not add client");
        }
        System.out.println(result);
    }
    /**
     * Method to be called for adding a customer.
     * Prompts the user for the appropriate values and
     * uses the appropriate Theater method for adding the client
     */
    public void addCustomer() {
        String name = getToken("Enter customer name");
        String address = getToken("Enter address");
        String phone = getToken("Enter phone");
        String creditCard = getToken("Enter credit card number");
        String expiryDate = getToken("Enter Credit Card expiration date");
        Customer result;
        result = theater.addCustomer(name, address, phone, creditCard, expiryDate);
        if (result == null) {
            System.out.println("Could not add customer");
        }
        System.out.println(result);
    }
    /**
     * Method to be called for adding a show.
     * Prompts the user for the appropriate values and
     * uses the appropriate Theater method for adding the show.
     *  // Add Logic for add a show only if theater is free during this period
     */
    public void addShows() {
    	Show result;
        do {
            String name = getToken("Enter Show name");
            String clientID = getToken("Enter client id"); 
            if(!theater.isValidClient(clientID)) {
            	System.out.println("Invalid client ID entered.");
            } else {            
            	Calendar startDate = getDate("Enter start date of the show(MM/DD/YYYY)");                       
            	// Verify startDate is in range, modify isThisDateValid() method
            	// to get a Calendar-type parameter 
            	if (startDate == null){ 
            		System.out.println("Invalid Date");    
            	}         
            	String strdate = startDate.toString();
            	if (!isThisDateValid(strdate)) {
            		System.out.println("Invalid Date - values out of range");
            	} 
            	//input is correct and can continue adding info           
            	else {                         		
            		int period = getNumber("Enter duration of the show");                 
            		// Add Logic for add a show only if theater is free during this period                
            		result = theater.addShow(name, clientID, startDate, period);                
            		if (result != null) {                  
            			System.out.println(result);                
            		} else {
            			System.out.println("Show could not be added");                
            		}
            	}
            }
            if (!yesOrNo("Add more shows?")) {
                break;
            }
        } while (true);
    	
    }
    /**
     * Method to be called for adding a credit card.
     * Prompts the user for the appropriate values and
     * uses the appropriate Theater method for adding the credit card.
     * If credit card on file, adding credit card to list fails.
     */
    public void addCreditCard() {
        String customerId = getToken("Enter Customer id");
        String creditCardNumber = getToken("Enter Credit Card Number");
        String expiryDate = getToken("Enter card expiration date (mm/dd/yy)");
        // Validating input
        if (doesCardAlreadyExist(creditCardNumber)){
        	System.out.println("Credit Card already in file under a different "
                    + "customer.");
        } else{
            CreditCard result = theater.addCreditCard(customerId, creditCardNumber, expiryDate);
            if (result != null){
                System.out.println(result.toString());
            } else{
                System.out.println("Card was unable to be added.");
            }
        }
    }
    /**
   * Method to be called for removing clients.
   * Prompts the user for the appropriate values and
   * uses the appropriate Theater method for removing clients.
   *  
   */
    public void removeClient() {
        int result;
        do {
            String clientID = getToken("Enter client id:");
            result = theater.removeClient(clientID);
            switch(result){
                case Theater.CLIENT_NOT_FOUND:
                  System.out.println("Client not found in Client List");
                  break;
                case Theater.CLIENT_HAS_UPCOMING_SHOW:
                  System.out.println("Client could not be removed, it "
                          + "has a current show playing or upcoming shows.");
                  break;
                case Theater.ACTION_FAILED:
                  System.out.println("Client could not be removed.");
                  break;
                case Theater.ACTION_COMPLETED:
                    System.out.println("Client has been removed");
                    break;
                default:
                  System.out.println("An error has occurred");
            }
            if (!yesOrNo("Remove more clients?")) {
              break;
            }
        } while (true);
    }
  /**
   * Method to be called for removing customers.
   * Prompts the user for the appropriate values and
   * uses the appropriate Theater method for removing customers.
   *  Catches return code to prompt to the user.
   */
    public void removeCustomer() {
        // result: int variable to save remove result
        // DoWhile loop for removing customers
        // String: Use getToken() to get Customer Id from user input
        // result = removing customer from list
        // Switch case based on result
        int result;
        do {
            String customerID = getToken("Enter Customer Id:");
            result = theater.removeCustomer(customerID);
            switch(result){
                case Theater.CUSTOMER_NOT_FOUND:
                    System.out.println("Customer not found in Customer List.");
                    break;
                case Theater.ACTION_COMPLETED:
                    System.out.println("Customer has been removed.");
                    break;
                case Theater.ACTION_FAILED:
                    System.out.println("Could not remove Customer.");
                    break;
                default: 
                    System.out.println("An error has ocurred.");
            }
            if(!yesOrNo("Remove nore customers?")){
                break;
            }
        } while (true);
    }
   /**
    * Method to be called for removing a customers credit card
    * Prompts user for id and card number, and uses appropriate theater method 
    * for removing that customers' credit card.
    * Catches return code to display to the user.
    */
    public void removeCreditCard() {
    	String customerID = getToken("Enter Customer Id:");
    	String creditCardNumber = getToken("Enter Credit Card Number:");
    	int result = theater.removeCreditCard(customerID, creditCardNumber);
    	
    	switch(result) {
    		case Theater.ACTION_COMPLETED:
    			System.out.println("Customers' credit card was removed.");
    			break;
    		case Theater.CUSTOMER_NOT_FOUND:
    			System.out.println("Customer not found in Customer List.");
    			break;
    		case Theater.CUSTOMER_HAS_ONE_CARD_ONLY:
    			System.out.println("Customer has only one credit card. "
    					+ "All customers must have atleast one card.");
    			break;
    		case Theater.CREDIT_CARD_NOT_FOUND:
    			System.out.println("The customer does not have a credit card with "
    					+ "that number.");
    			break;
    		case Theater.ACTION_FAILED:
    			System.out.println("Could not remove customers' Credit Card");
    			break;
    		default: 
                System.out.println("An error has ocurred.");
    	}
    }
    /**
     * Method to be called for listing all clients.
     * Prompts the user for the appropriate values and
     * uses the appropriate Theater method for displaying client list.
     *  
     */
    public void getClients() {
        Iterator result;
        result = theater.getClientList();
        if (!result.hasNext()) {
        	// hasNext returns false if there are no contents in the list
            System.out.println("Client List is empty.");
        } else {
            while(result.hasNext()) {
                Client client = (Client) result.next();
                System.out.println(client.toString());
            }
            System.out.println("\n**There are no more clients** \n" );
        }
    }
    /**
     * Method to be called for listing all customers.
     * Prompts the user for the appropriate values and
     * uses the appropriate Theater method for displaying customer list.
     *  
     */
    public void getCustomers() {
        Iterator result;
        result = theater.getCustomerList();
        if (!result.hasNext()) {
        	// hasNext returns false if there are no contents in the list
            System.out.println("Customer List is empty.");
        } else {
            while(result.hasNext()) {
                Customer customer = (Customer) result.next();
                System.out.println(customer.toString());
            }
            System.out.println("\n**There are no more customers**\n" );
        }
    }
    /**
     * Method to be called for displaying shows.
     * Prompts the user for the appropriate values and
     * uses the appropriate Theater method for displaying shows.
     *  
     */
    public void getShows() {
      Iterator result;
        result = theater.getShowList();
        if (result.hasNext()) {
        	// hasNext returns false if there are no contents in the list
            System.out.println("Show List is empty.");
        } else {
            while(result.hasNext()) {
                Show show = (Show) result.next();
                System.out.println(show.toString());
            }
            System.out.println("\n**There are no more shows**\n" );
        }
    }
    /**
     * Method to be called for saving the Theater object.
     * Uses the appropriate Theater method for saving.
     *  
     */
    private void storeData() {
        if (theater.storeData()) {
            System.out.println("The theater has been successfully saved "
                    + "in the file \"TheaterData\" \n" );
        } else {
            System.out.println("There has been an error in saving Theater data \n" );
        }
    }
    /**
     * Method to be called for retrieving saved data.
     * Uses the appropriate Theater method for retrieval.
     *  
     */
    private void retrieveData() {
      try {
        Theater tempTheater = Theater.retrieve();
        if (tempTheater != null) {
          System.out.println("The theater has been successfully retrieved "
                  + "from the file TheaterData \n" );
          theater = tempTheater;
        } else {
          System.out.println("File doesnt exist; creating new theater \n" );
          theater = Theater.instance();
        }
      } catch(Exception cnfe) {
        cnfe.printStackTrace();
      }
    }
    /*
     * Supplementary function to test validation of date (MM/DD/YY) entered in by user
     * If month or date is out of range, returns false. Else, returns true
     * Code based on: https://www.mkyong.com/java/how-to-check-if-date-is-valid-in-java/
     */
	public boolean isThisDateValid(String dateToValidate){

		if(dateToValidate == null){
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);

		try {

			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Checks if the given card already exists in the database
	 * @return True, if the card already exists, else false.
	 */
    private boolean doesCardAlreadyExist(String creditCardNumber) {
        /*
         * Loops through all customers looking to see if any of them already
         * have a credit card with the given number.
         */
        Iterator custIterator = theater.getCustomerList();
        while (custIterator.hasNext()) {
        	Customer customer = (Customer) custIterator.next();
    		Iterator credIterator = customer.getCreditCardList();
    		while (credIterator.hasNext()) {
    			CreditCard creditCard = (CreditCard) credIterator.next();
    			if (creditCard.getCardNum().equals(creditCardNumber)) {
    				return true; // a customer already has a card with this number
    			}
    		}
        }
        return false; // no customers found with the given card number
    }
    
    /**
     * Supplementary function to validate clerk's entered ID. Primarily
     * used in addShows to ensure only enterring shows for existing clients
     * @return True, if clientID entered is of existing client in list, else false
     */
    private boolean isValidClient(String clientID) {
    	if(isValidClient(clientID))
    		return true;
    	else 
    		return false;
    }
    
    /**
     * Orchestrates the whole process.
     * Calls the appropriate method for the different functionalities.
     *  
     */
    public void process() {
      int command;
      help();
      while ((command = getCommand()) != EXIT) {
        switch (command) {
          case ADD_CLIENT:        addClient();
                                  break;
          case REMOVE_CLIENT:     removeClient();
                                  break;
          case LIST_CLIENTS:      getClients();
                                  break;
          case ADD_CUSTOMER:      addCustomer();
                                  break;
          case REMOVE_CUSTOMER:   removeCustomer();
                                  break;
          case ADD_CREDIT_CARD:   addCreditCard();
                                  break;
          case REMOVE_CREDIT_CARD:removeCreditCard();
                                  break;
          case LIST_CUSTOMERS:    getCustomers();
                                  break;
          case ADD_SHOW:          addShows();
                                  break;
          case LIST_SHOWS:        getShows();
                                  break;
          case STORE_DATA:        storeData();
                                  break;
          case RETRIEVE_DATA:     retrieveData();
                                  break;
          case HELP:              help();
                                  break;
        }
      }
      storeData();
    }
    /**
     * The method to start the application. Simply calls process().
     * @param args not used
     */
    public static void main(String[] args) {
        UserInterface.instance().process();
    }
}