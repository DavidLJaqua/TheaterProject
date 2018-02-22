
package Theater;
import java.io.Serializable;

public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;
	private String customerID;
	private String cardNum ;
	private String expDate;
	
	/*Constructor*/
	public CreditCard(String customerID, String cardNum, String expDate) {
		super();
		this.customerID = customerID;
		this.cardNum = cardNum;
		this.expDate = expDate;
	}
	
	/*Getters*/
	public String getCustomerID() {
		return customerID;
	}
	
	public String getCardNum() {
		return cardNum;
	}
	public String getExpDate() {
		return expDate;
	}
	/*Setters*/
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	/*To String method - to output basic creditCard data*/
	@Override
	public String toString() {
		return "CreditCard [customerID=" + customerID + ", cardNum=" + cardNum + ", expDate=" + expDate + "]";
	}
	
	

}
