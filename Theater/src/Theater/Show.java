/**
 * Project: OOAD_Project_1_Theater
 */

package Theater;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;



/** 
 * Show class represents a show/play.
 * It has name, the client who owns the show, date for show release, and 
 * period of time for playing the show.
 *
 * @author Franklin Ortega
 * Date: Feb 21, 2018
 */
public class Show implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String clientId;
    private Calendar date;
    private Calendar startDate;
    private Calendar endDate;
    private List showList = new LinkedList();

    /**
     *
     * @param name name of the show
     * @param clientId the owner of the show
     * @param startDate The first presentation of the show.
     * @param endDate 
     * @param duration the time period for show.
     */
    public Show(String name, String clientId, int duration) {
        this.name = name;
        this.clientId = clientId;
        this.date = new GregorianCalendar();
        date.setTimeInMillis(System.currentTimeMillis());
        date.add(Calendar.DATE, duration);
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getClientId() {
        return clientId;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }
    
    /**
     *
     * @param Date
     * @return
     */
    public boolean isTheaterAvailable(Calendar Date){
        return false;
    }

} // End of class Show
