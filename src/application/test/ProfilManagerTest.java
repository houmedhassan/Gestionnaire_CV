package application.test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.beans.Activity;
import application.beans.Nature;
import application.beans.Person;
import application.business.PersonActivityManagerImpl;
import application.business.ProfilManagerImpl;

public class ProfilManagerTest {
	
	@EJB
	PersonActivityManagerImpl personActivityImpl;
	
	@EJB
	ProfilManagerImpl profilManager;
	
	
	Person person = new Person();
	
	 public ProfilManagerTest() throws Exception {
	        EJBContainer.createEJBContainer().getContext().bind("inject", this);
	        assertNotNull(personActivityImpl);
	        assertNotNull(profilManager);
	  }
	 
	@Test
	public void loginTest(){
		profilManager.loginPerson("houmedhassan@outlook.com", "123456");
		//System.out.println(profilManager.getUser());
		assertNotNull(profilManager.getUser());
	}
	
	@Test
	public void logoutTest(){
		profilManager.loginPerson("houmedhassan@outlook.com", "123456");
		//System.out.println( profilManager.getUser().getFirstName());
		profilManager.logout();
		assertNull(profilManager.getUser());
	}
	
	@Test
	public void deleteProfilTest(){
		
	}

	@Test
	public void addActivityTest(){
		Person p= profilManager.loginPerson("houmedhassan@outlook.com", "123456");
		//System.out.println(profilManager.getUser().getFirstName());
		//assertNotNull(p);
		//System.out.println(p.getFirstName());
		//Person p = personActivityImpl.showPerson(1);
		Activity activity= new Activity();
		activity.setTitle("developpeur java jee");
		activity.setDescription("realiser une application qui permet de mettre en ligne un CV");
		activity.setNature(Nature.experience_professionnel);
		activity.setPerson(p);
		
		profilManager.addActivity(activity);
		
	}
	
	@Test
	public void deleteActivityTest(){
		Activity activity = personActivityImpl.showActivity(1);
		profilManager.deleteActivity(activity);
		assertNull(personActivityImpl.showActivity(1));
	}
	
	 /*
	@Before
	public void setUp() throws Exception {
		// person.setIdPerson(1);
		 person.setLastName("HASSAN MOHAMED");
		 person.setFirstName("Houmed");
		 person.setMail("houmedhassan@outlook.com");
		 person.setWebSite("page.perso.univ-luminy");
		
		 person.setBirthday(new Date(91, 10, 31));
		 person.setPassword("123545");
		 personActivityImpl.addPerson(person);
	}*/
	
	/*
	@Test(expected=Exception.class)
	public void loginErrorTest(){
		profilManager.loginPerson("houmedhassan@outlook.com", "12");
	}*/
	
}
