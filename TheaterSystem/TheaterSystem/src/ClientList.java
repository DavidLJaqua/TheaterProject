package Theater;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ClientList represents a singleton class which encloses a list of clients.
 * ClientList is saved with Theater class on program shutdown.
 * @author David Jaqua
 */
public class ClientList implements Serializable{

	private static final long serialVersionUID = 1L;
	/*
	 * Singleton instance of the ClientList
	 */
	private static ClientList clientListInstance;
	private List<Client> clientList;

	private ClientList() {
		clientList = new LinkedList<Client>();
	}
	
	public static ClientList instance(){
		if (clientListInstance == null){
			return (clientListInstance = new ClientList());
		} else{
			return clientListInstance;
		}
	}
	
	public Client search(String clientID){
		for (Client client : clientList){
			if (client.getClientID().equals(clientID)){
				return client; // client found with id
			}
		}
		return null; // no client found with id
	}
	
	public boolean insertClient(Client client){
		return clientList.add(client);
	}
	
	public boolean removeClient(String clientID){
		for (Client client : clientList){
			if (client.getClientID().equals(clientID)){
				// we found the client with the specified client ID, remove them from list
				clientList.remove(client);
				return true;
			}
		}
		return false;
	}
	
	public Iterator<Client> getClients(){
		return clientList.iterator();
	}
	
	public String toString(){
		// TODO
		return "";
	}
}
