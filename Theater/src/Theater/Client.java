package Theater;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Client class represents a client who has attributes such as a name, address
 * phone number, client ID, and balance.
 * @author David Jaqua
 */
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name, address, phoneNum, clientID;
	private static final String CLIENT_STRING = "Cli";
	private int balance;

	/**
	 * Creates a new client object with the given info and set's their balance to 0
	 */
	public Client(String name, String address, String phoneNum){
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		balance = 0;

		// fetch a new client id
		clientID = CLIENT_STRING + ClientIDServer.instance().getID();
    }

	/**
	 * Gets the clients' name
	 * @return clients' name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Gets the clients' address
	 * @return clients' address
	 */
	public String getAddress(){
		return address;
	}

	/**
	 * Gets the clients' phone number
	 * @return clients' phone number
	 */
	public String getPhoneNum(){
    	return phoneNum;
	}

	/**
	 * Gets the clients' ID
	 * @return clients' ID
	 */
	public String getClientID(){
		return clientID;
	}

	/**
	 * Gets the clients' balance
	 * @return clients' balance
	 */
	public int getBalance(){
		return balance;
	}

	/**
	 * Sets the clients' name
	 * @param name clients' new name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Sets the clients' address
	 * @param address clients' new address
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 * Sets the clients' phone number
	 * @param phoneNum clients' new phone number
	 */
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
 	}

	/**
	 * Sets the clients' balance
	 * @param balance clients' new balance
	 */
	public void setBalace(int balance){
		this.balance = balance;
	}
    
	/**
	 * Checks if the client has a current or upcoming show
	 * @return true if the client has a current or upcoming show
	 */
	public boolean hasUpcomingShow() {
		Calendar currentDate = Calendar.getInstance();
		Iterator iterator = Theater.instance().getShowList();
		Show show;
		
		/*
		 * Loops through all shows looking for one by the client that
		 * is currently in progress or has a future end date
		 */
		while(iterator.hasNext()) {
			show = (Show) iterator.next();
			if (show.getClientId().equals(clientID)
					&& show.getEndDate().after(currentDate)) {
				/*
				 * this show ends after the current date
				 */
				return true; // client has a current/future show
			}
		}
		return false; // client has no current/future shows
	}
	
	@Override
	public String toString(){
		return "Client [name=" + name + " address=" + address + " phoneNum=" + phoneNum 
				+ " clientID=" + clientID + " balance=" + balance + "]";
	}
}