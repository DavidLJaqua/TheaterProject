package Theater;

/*
 * Author : Vanessa 
 * code for CustomerIdServer based heavily upon the MemberIdServer class,
 * since they have analogous functionality 
*/

/*
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

import java.io.*;
/**
* Generates Customer ids.
* @author Brahma Dathan and Sarnath Ramnath
*
*/
public class CustomerIdServer implements Serializable {
 private  int idCounter;
 private static CustomerIdServer server;
 
 // Private constructor for singleton pattern
 private CustomerIdServer() {
   idCounter = 1;
 }
 /**
  * Supports the singleton pattern
  * 
  * @return the singleton object
  */
 public static CustomerIdServer instance() {
   if (server == null) {
     return (server = new CustomerIdServer());
   } else {
     return server;
   }
 }
 /**
  * getId() gets customer id
  * @return id of the Customer
  */
 public int getId() {
   return idCounter++;
 }
 /** 
  * String form of the collection
  * 
 */
 @Override
 public String toString() {
   return ("IdServer" + idCounter);
 }
 /**
  * Retrieves the server object
  * 
  * @param input input stream for deserialization.
  */
 public static void retrieve(ObjectInputStream input) {
   try {
     server = (CustomerIdServer) input.readObject();
   } catch(IOException ioe) {
     ioe.printStackTrace();
   } catch(Exception cnfe) {
     cnfe.printStackTrace();
   }
 }
 /*
  * Supports serialization
  * @param output the stream to be written to
  */
 private void writeObject(java.io.ObjectOutputStream output) throws IOException {
   try {
     output.defaultWriteObject();
     output.writeObject(server);
   } catch(IOException ioe) {
     ioe.printStackTrace();
   }
 }
 /*
  * Supports serialization
  * @param input the stream to be read from
  */
 private void readObject(java.io.ObjectInputStream input) throws IOException, ClassNotFoundException {
   try {
     input.defaultReadObject();
     if (server == null) {
       server = (CustomerIdServer) input.readObject();
     } else {
       input.readObject();
     }
   } catch(IOException ioe) {
     ioe.printStackTrace();
   }
 }
}
