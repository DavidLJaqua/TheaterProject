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

	/**
	 * Creates singleton instance of the ClientList
	 */
	private ClientList() {
		clientList = new LinkedList<Client>();
	}
	
	/**
	 * Retrieves the singleton instance of ClientList
	 * @return ClientList instance
	 */
	public static ClientList instance(){
		if (clientListInstance == null){
			return (clientListInstance = new ClientList());
		} else{
			return clientListInstance;
		}
	}
	
	/**
	 * Searches the clientList for a client with the specified client ID
	 * @param clientID ID of the client to search for
	 * @return Client of with the given ID, otherwise null
	 */
	public Client search(String clientID){
		for (Client client : clientList){
			if (client.getClientID().equals(clientID)){
				return client; // client found with id
			}
		}
		return null; // no client found with id
	}
	
	/**
	 * Inserts the client into the list
	 * @param client to insert
	 * @return whether or not the client was able to be inserted
	 */
	public boolean insertClient(Client client){
		return clientList.add(client);
	}
	
	/**
	 * Removes the client with the specified client ID from the list
	 * @param clientID ID of the client to remove
	 * @return whether or not the client with the id was removed
	 */
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
	
	/**
	 * Gets an iterator of the client list
	 * @return client list iterator
	 */
	public Iterator<Client> getClients(){
		return clientList.iterator();
	}
	
	@Override
	public String toString() {
		return clientList.toString();
	}
}