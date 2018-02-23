package Theater;

/**
 * Project: OOAD_Project_1_Theater
 */

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



/** 
 * ShowList class 
 *
 * @author Franklin Ortega
 * Date: Feb 23, 2018
 */
public class ShowList implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ShowList showListInstance;
    private List showList = new LinkedList<>();

    private ShowList() {
    }

    /**
     * Implements the singleton class of ShowList.
     * 
     * @return new instance of singleton class if doesn't exists, otherwise
     *          returns an existing one.
     */
    public static ShowList instance(){
            if (showListInstance == null){
                return (showListInstance = new ShowList());
            } else{
                return showListInstance;
            }
    }

    /**
     * Search for a specific show based in a show name.
     * 
     * @param showName name of the show used to search a specific show in list.
     * @return show object.
     */
    public Show search(String showName){
        for(Iterator iterator = showList.iterator(); iterator.hasNext();){
            Show show = (Show) iterator.next();
            if (show.getName().equals(showName)) {
                return show;
            }
        }
        return null; 
    }

    /**
     * Adds customer to Customer List.
     * 
     * @param show object that will be saved in show list.
     * @return true if show has been added to the list, false otherwise. 
     */
    public boolean insertShow(Show show){
        return showList.add(show);
    }

    /**
     * Removes a customer from the CustomerList, it uses customer id for 
     * identifying customer on the list.
     * 
     * @param showName name of the show to be removed
     * @return true if customer has been removed, false otherwise.
     */
    public boolean removeShow(String showName){
        for (Iterator iterator = showList.iterator(); iterator.hasNext();){
            Show show = (Show) iterator.next();
            if (show.getName().equals(showName)){
                // we found the customer with the specified client ID, remove them from list
                showList.remove(show);
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return an iterator of the Show List.
     */
    public Iterator getShowList(){
        return showList.iterator();
    }

    @Override
    public String toString() {
        return showList.toString();
    }

} // End of class ShowList
