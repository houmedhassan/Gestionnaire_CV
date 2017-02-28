package application.test;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.Test;

import application.beans.Person;
import application.business.PersonActivityManagerImpl;

public class PersonActivityManagerTest {

	@EJB
	PersonActivityManagerImpl personActivityImpl;
	
	Person person = new Person();
	
	 public PersonActivityManagerTest() throws Exception {
	        EJBContainer.createEJBContainer().getContext().bind("inject", this);
	        assertNotNull(personActivityImpl);
	  }
	 
	 /**
	  * this method test if the person was save in database
	  */
	 /*@Test
	 public void addPersonTest(){
		// person.setIdPerson(1);
		 person.setLastName("HAMOUD MANLID");
		 person.setFirstName("Abdoulrahim");
		 person.setMail("abdoulrahiim@gmail.com");
		 person.setWebSite("page.perso.univ-luminy");
		
		 person.setBirthday(new Date(91, 10, 31));
		 person.setPassword("123");
		 personActivityImpl.addPerson(person);
		 
	 }*/
	 
	 @Test
	 public void showPersonTest(){
		 /*Person person = new Person();
		 person.setIdPerson(6);
		 */
		 Person show = new Person();
		 show=personActivityImpl.showPerson(1);
		
		 assertNotNull(show.getLastName());	 
	 }	 
	
	 @Test
	 public void showActivity(){
		 assertNotNull(personActivityImpl.showActivity(1));
	 }
	 
	 @Test
	 public void listActivityTest(){
		
		person= personActivityImpl.showPerson(1);
						
		assertNotNull(personActivityImpl.listActivityByPerson(person));
	 }
	 
	 @Test
	 public void findCvActivityTest(){
		 personActivityImpl.findCvActivity("java");
		 assertNotNull( personActivityImpl.findCvActivity("java"));
		 System.out.println(personActivityImpl.findCvActivity("java").size());
	 }
}
