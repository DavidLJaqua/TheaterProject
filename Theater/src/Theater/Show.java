package Theater;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;

/** 
 * Show class represents a show/play which is held on in a theater on a range of days
 * It has a show name, the client id who owns the show, date for show release, and 
 * a date for the show finale.
 *
 * @author David Jaqua
 */
public class Show implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String clientID;
	private Calendar startDate;
	private Calendar endDate;

	/**
	 * Creates a new show with the given name, clientID, start year, month, day, and the
	 * duration of showing in days.
	 * 
	 * <br><br>
	 * 
	 * <b>WARNING!</b> This does not check if the show can be held within this range of days!
	 * The class that uses this show must check before inserting this show into the ShowList using
	 * isTheaterAvailable()
	 * 
	 * @param name name of the show
	 * @param clientID the owner of the show
	 * @param year the year value for the start date
	 * @param month the month value for the start date
	 * @param day the day value for the start date
	 * @param duration the number of days the show will be held
	 */
	public Show(String name, String clientID, int year, int month, int day, int duration) {
		this.name = name;
		this.clientID = clientID;
		/*
		 * month is subtracted by 1 because the month is 0-based (0 = January)
		 */
		startDate = Calendar.getInstance(); // get new calendar instance
		startDate.clear(); // clear the calendars existing values
		startDate.set(year, month-1, day);
		/*
		 * determines the end date by adding the duration of days onto the start date
		 */
		endDate = Calendar.getInstance(); // get new calendar instance
		endDate.clear(); // clear the calendars existing values
		endDate.set(year, month-1, day);
		endDate.add(Calendar.DAY_OF_MONTH, duration);
	}

	/**
	 * Gets the shows' name
	 * @return The shows' name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the shows' owners' client id
	 * @return The clients' id
	 */
	public String getClientId() {
		return clientID;
	}

	/**
	 * Gets the start date of the show
	 * @return calendar representation of the start date
	 */
	public Calendar getStartDate() {
		return startDate;
	}
	
	/**
	 * Gets the end date of the show
	 * @return calendar representation of the end date
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * Sets the shows' name
	 * @param name New name of the show
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the shows' clients' id
	 * @param clientID the new client ID
	 */
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
	/**
	 * Sets the start date of the show
	 * <br><br>
	 * <b>WARNING!</b> This does not check if the show can be held within this new range of days!
	 * The class that uses this show must check before inserting this show into the ShowList using
	 * isTheaterAvailable()
	 * 
	 * @param startDate The new start date
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Sets the end date of the show
	 * <br><br>
	 * <b>WARNING!</b> This does not check if the show can be held within this new range of days!
	 * The class that uses this show must check before inserting this show into the ShowList using
	 * isTheaterAvailable()
	 * 
	 * @param endDate The new end date
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Checks if a specified start and end date of a "show to be" is available
	 * @param startDate the starting date of a show
	 * @param endDate the ending date of a show
	 * @return true if the theater is available (no collisions with existing shows) otherwise, false
	 */
	
	/*public static boolean isTheaterAvailable(Calendar startDate, Calendar endDate){
		Iterator iterator = Theater.instance().getShowList();
		Show show;
		
		while(iterator.hasNext()) {
			show = (Show) iterator.next();
			
			// check if the startDate is between this shows' start and end dates
			if (startDate.after(show.getStartDate()) 
					&& startDate.before(show.getEndDate())) {
				/*
				 * the theater is not available for this time (specified start date is between 
				 * another shows' start and end dates)
				 */
	/*			return false;
			}
			
			// check if the endDate is between this shows' start and end dates
			if (endDate.after(show.getStartDate()) 
					&& startDate.before(show.getEndDate())) {
				/*
				 * the theater is not available for this time (specified end date is between
				 * another shows' start and end dates 
				 */
	/*			return false;
			}
			
		}
		// no collisions found with existing shows; theater is available for this date range
		return true;
	}*/
	
	@Override
	public String toString(){
		return "Show [name=" + name + " clientID=" + clientID + " startDate=" + dateToString(startDate) 
				+ " endDate=" + dateToString(endDate) + "]";
	}
	
	/**
	 * Gets a custom toString value of a java Calendar date
	 * @param date Java Calendar date to convert
	 * @return String representation of the date
	 */
	public static String dateToString(Calendar date) {
		return "Calendar [year=" + date.get(Calendar.YEAR) + " month=" + date.get(Calendar.MONTH)
				+ " day=" + date.get(Calendar.DAY_OF_MONTH) + " hour=" + date.get(Calendar.HOUR_OF_DAY) 
				+ " minute=" + date.get(Calendar.MINUTE) + "]";
	}

}