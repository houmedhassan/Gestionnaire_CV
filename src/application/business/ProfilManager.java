package application.business;

import java.util.List;

import application.beans.Person;

public interface ProfilManager {
	
	/**
	 * This method adds a new person.
	 * it's a function which allows a new user signing up
	 * @param p
	 * @return person
	 */
	public Person signUpPerson(Person p);
	
	/**
	 * this method allows a user's to login in app.
	 * @param mail
	 * @param password
	 * @return person
	 */
	public Person loginPerson(String mail, String password);
	
	/**
	 * this method allows show a profil of user's.
	 * @return
	 */
	public Person showProfil();
	
	/**
	 * this method allows to make update a profil of a person
	 * @param idPerson
	 * @return person
	 */
	public Person updateProfilPerson(int idPerson);
	
	/**
	 * this method return the list of person whose the name passed to parameter
	 * @param name
	 * @return the list of person
	 */
	public List<Person> searchPersonByName(String name);
	
	/**
	 * this method remove the user.
	 * @param p
	 */
	public void deleteProfil(Person p);

}
