package application.business;

import java.util.List;

import application.beans.Activity;
import application.beans.Person;

public interface PersonActivityManager {
	
	/**
	 * this method allows of save an activity
	 * @return Activity
	 * @param activity
	 */
	public Activity addActivity(Activity activity);
	
	/**
	 * this method allows to make update an activity of a person
	 * @return Activity
	 * @param idActivity, activity
	 */
	public Activity updateActivity(int idActivity, Activity activity);
	
	/**
	 * this method allows of remove an activity of a person
	 * @param activity
	 */
	public void RemoveActivity(Activity activity);
	
	/**
	 * this method allows to show an activity ( like title, year of the actvity, nature of the activity,
	 * the description of activity and website of activite if it exists). 
	 * @return Activity
	 */
	public Activity showActivity();
	
	/**
	 * this method return the list of activity by person
	 * @return list of Activity
	 */
	public List <Activity> listActivityByPerson(Person p);
	
	/**
	 * this method return the list of activities which  have the title passed to parameter
	 * @param title
	 * @return the list of Activity
	 */
	public List<Activity> findActivityByTitle( String title);
	
	/**
	 * this method allows to find the person by activity whose have the title passed to parameter
	 * @param title
	 * @return the list of Person
	 */
	public List <Person> findPersonByActivity(String title);
}
