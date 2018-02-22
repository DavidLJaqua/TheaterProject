package Theater;

public class Driver {

	public static void main(String[] args){
		Client client1 = new Client("Bob", "12345 ABC", "555-666-1234");
		Client client2 = new Client("Sally", "11122 ABC", "111-222-1234");
		
		ClientList clientList = ClientList.instance();
		clientList.insertClient(client1);
		clientList.insertClient(client2);
		
		System.out.println("clientList has client1? " + (clientList.search(client1.getClientID()) != null) );
		System.out.println("clientList has client2? " + (clientList.search(client2.getClientID()) != null) );
		
		System.out.println("client1 toString: " + clientList.search(client1.getClientID()).toString());
		System.out.println("client2 toString: " + clientList.search(client2.getClientID()).toString());
		
		clientList.removeClient(client1.getClientID());
		System.out.println("removed client1. clientList has client1? " + (clientList.search(client1.getClientID()) != null) );
		
		Client client3 = new Client("Marry", "99999", "222-333-4444");
		clientList.insertClient(client3);
		System.out.println("added client 3");
		
		System.out.println("clientList current contents: ");
		System.out.println(clientList.toString());
	}
}