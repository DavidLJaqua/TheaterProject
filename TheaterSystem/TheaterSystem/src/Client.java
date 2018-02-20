package Theater;

/**
 * Client class represents a client who has attributes such as a name, address
 * phone number, client ID, and balance.
 * @author David Jaqua
 */
public class Client {

	private String name, address, phoneNum, clientID;
	private static final String CLIENT_STRING = "Cli";
	private int balance;
	
	public Client(String name, String address, String phoneNum){
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		balance = 0;
		
		// fetch a new client id
		clientID = CLIENT_STRING + ClientIDServer.instance().getID();
	}
	
	// Getters
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getPhoneNum(){
		return phoneNum;
	}
	
	public String getClientID(){
		return clientID;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public String toString(){
		return "Client [name=" + name + " address=" + address + " phoneNum=" + phoneNum 
				+ " clientID=" + clientID + " balace=" + balance + "]"; 
	}
	
	// Setters
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}
	
	public void setBalace(int balance){
		this.balance = balance;
	}
}