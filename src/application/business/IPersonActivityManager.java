package application.business;

import java.util.List;

import application.beans.Activity;
import application.beans.Person;

public interface IPersonActivityManager {
	
	/**
	 * This method adds a new person.
	 * it's a function which allows a new user signing up
	 * @param p
	 *
	 */
	public void addPerson(Person p);
	
	/**
	 * this method allows show a profil of user's.
	 * @param p
	 * @return person
	 */
	public Person showPerson(Person p);
	
	/**
	 * this method return the list of person whose the name passed to parameter
	 * @param name
	 * @return the list of person
	 */
	public List<Person> findPersonByName(String name);
	
	/**
	 * this method allows to show an activity ( like title, year of the actvity, nature of the activity,
	 * the description of activity and website of activite if it exists). 
	 * @param activity
	 * @return Activity
	 */
	public Activity showActivity(Activity activity);
	
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
	public List<Activity> findActivityByTitle(String title);
	
	/**
	 * this method allows to find the person by activity whose have the title passed to parameter
	 * @param title
	 * @return the list of Person
	 */
	public List <Person> findPersonByActivity(String title);
}
