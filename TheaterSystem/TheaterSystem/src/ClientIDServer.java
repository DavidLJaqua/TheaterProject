package Theater;

import java.io.Serializable;

/**
 * ClientIDServer class servers as a way of getting a new, unique ID for client creation.
 * Will be saved along with the Theater class when the program is shutdown.
 * @author David Jaqua
 */
public class ClientIDServer implements Serializable{

	private static final long serialVersionUID = 1L;
	/*
	 * Singleton instance of the ClientIDServer
	 */
	private static ClientIDServer serverInstance;
	private int idCounter;
	
	private ClientIDServer() {
		idCounter = 1;
	}
	
	public static ClientIDServer instance(){
		if (serverInstance == null){
			return (serverInstance = new ClientIDServer());
		} else{
			return serverInstance;
		}
	}
	
	/**
	 * Gets a new, unique ID for a client
	 * @return Unique client ID
	 */
	public int getID(){
		return idCounter++; // returns current unique id, then increments it for the next call
	}
}
