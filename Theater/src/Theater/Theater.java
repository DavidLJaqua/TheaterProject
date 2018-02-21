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
//    private ShowList showList;
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
//      showList = ShowList.instance();
      customerList = CustomerList.instance();
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
//    public Show addShow(String name, String clientID, String period) {
//      Show show = new Show(name, clientID, period);
//      if (showList.insertShow(show)) {
//        return (show);
//      }
//      return null;
//    }
    /**
    * Organizes the operations for adding a customer
    * @param name customer name
    * @param address customer address
    * @param phone customer phone
    * @return the Customer object created
    */
    public Customer addCustomer(String name, String address, String phone) {
        Customer customer = new Customer(name, address, phone);
        if (customerList.insertCustomer(customer)) {
            return (customer);
        }
        return null;
    }
    /**
     * Organizes the placing of a hold
     * @param memberId member's id
     * @param bookId book's id
     * @param duration for how long the hold should be valid in days
     * @return indication on the outcome
     */
//    public int placeHold(String memberId, String bookId, int duration) {
//      Book book = catalog.search(bookId);
//      if (book == null) {
//        return(BOOK_NOT_FOUND);
//      }
//      if (book.getBorrower() == null) {
//        return(BOOK_NOT_ISSUED);
//      }
//      Member member = memberList.search(memberId);
//      if (member == null) {
//        return(NO_SUCH_MEMBER);
//      }
//      Hold hold = new Hold(member, book, duration);
//      book.placeHold(hold);
//      member.placeHold(hold);
//      return(HOLD_PLACED);
//    }
    /**
     * Searches for a given member
     * @param memberId id of the member
     * @return true if the member is in the member list collection
     */
//    public Member searchMembership(String memberId) {
//      return memberList.search(memberId);
//    }
    /**
     * Processes holds for a single book
     * @param bookId id of the book
     * @return the member who should be notified
     */
//    public Member processHold(String bookId) {
//      Book book = catalog.search(bookId);
//      if (book == null) {
//        return (null);
//      }
//      Hold hold = book.getNextHold();
//      if (hold == null) {
//        return (null);
//      }
//      hold.getMember().removeHold(bookId);
//      hold.getBook().removeHold(hold.getMember().getId());
//      return (hold.getMember());
//    }
    /**
     * Removes a hold for a specific book and member combincation
     * @param memberId id of the member
     * @param bookId book id
     * @return result of the operation 
     */
//    public int removeHold(String memberId, String bookId) {
//      Member member = memberList.search(memberId);
//      if (member == null) {
//        return (NO_SUCH_MEMBER);
//      }
//      Book book = catalog.search(bookId);
//      if (book == null) {
//        return(BOOK_NOT_FOUND);
//      }
//      return member.removeHold(bookId) && book.removeHold(memberId)? OPERATION_COMPLETED: NO_HOLD_FOUND;
//    }
    /*
     * Removes all out-of-date holds
     */
//    private void removeInvalidHolds() {
//      for (Iterator catalogIterator = catalog.getBooks(); catalogIterator.hasNext(); ) {
//        for (Iterator iterator = ((Book) catalogIterator.next()).getHolds(); iterator.hasNext(); ) {
//          Hold hold = (Hold) iterator.next();
//          if (!hold.isValid()) {
//            hold.getBook().removeHold(hold.getMember().getId());
//            hold.getMember().removeHold(hold.getBook().getId());
//          }
//        }
//      }
//    }
    /**
     * Organizes the issuing of a book
     * @param memberId member id
     * @param bookId book id
     * @return the book issued
     */
//    public Book issueBook(String memberId, String bookId) {
//      Book book = catalog.search(bookId);
//      if (book == null) {
//        return(null);
//      }
//      if (book.getBorrower() != null) {
//        return(null);
//      }
//      Member member = memberList.search(memberId);
//      if (member == null) {
//        return(null);
//      }
//      if (!(book.issue(member) && member.issue(book))) {
//        return null;
//      }
//      return(book);
//    }
    /**
     * Renews a book
     * @param bookId id of the book to be renewed
     * @param memberId member id
     * @return the book renewed
     */
//    public Book renewBook(String bookId, String memberId) {
//      Book book = catalog.search(bookId);
//      if (book == null) {
//        return(null);
//      }
//      Member member = memberList.search(memberId);
//      if (member == null) {
//        return(null);
//      }
//      if ((book.renew(member) && member.renew(book))) {
//        return(book);
//      }
//      return(null);
//    }
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
//        if (client.hasActiveShow()) {     // Need to be implemented
//            return(CLIENT_HAS_UPCOMING_SHOW);
//        }
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
     * Returns an iterator to the transactions for a specific member on a certain date
     * @param memberId member id
     * @param date date of issue
     * @return iterator to the collection
     */
  //  public Iterator getTransactions(String memberId, Calendar date) {
  //    Member member = memberList.search(memberId);
  //    if (member == null) {
  //      return(null);
  //    }
  //    return member.getTransactions(date);
  //  }
  //  




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