package application.business;

import java.util.List;

import application.beans.Activity;
import application.beans.Person;


public interface IProfilManager {
	
	
	/**
	 * this method allows to make update a profil of a person
	 * @param idPerson
	 * @return person
	 */
	public Person updatePerson(int idPerson);
	
	/**
	 * this method remove the user.
	 * @param p
	 */
	public void deleteProfil(Person p);
		
	/**
	 * this method allows a user's to login in app.
	 * @param mail
	 * @param password
	 * @return person
	 */
	public Person loginPerson(String mail, String password);
	
	
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
	public void deleteActivity(Activity activity);
}
