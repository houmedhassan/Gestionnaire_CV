package application.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import application.beans.Person;
import application.business.PersonActivityManagerImpl;

@ManagedBean(name="user_navigation")
public class NavigationController {
	
	@EJB
	PersonActivityManagerImpl personActivityManager;
	
	
	Person person = new Person();
	
	List <Person> personSearch = new ArrayList<Person>();
	List <Person> pers = new ArrayList<Person>();
	
	private String search;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
	
	public List<Person> getPersonSearch() {
		return personSearch;
	}

	public void setPersonSearch(List<Person> personSearch) {
		this.personSearch = personSearch;
	}

	
	
	
	
	
	public List<Person> getPers() {
		return pers;
	}

	public void setPers(List<Person> pers) {
		this.pers = pers;
	}

	public String home() {
		return "home?faces-redirect=true";
	}
	
	public String newPerson(){
		person = new Person();
		return "ajoutPerson?faces-redirect=true";
	}
	
	public String  savePerson(){
		personActivityManager.addPerson(person);
		/*FacesMessage message_ok = new FacesMessage(FacesMessage.SEVERITY_INFO, "Votre inscription c'est bien deroul�, vous pouvez vous connecter", null);
		FacesContext.getCurrentInstance().addMessage(null, message_ok);
		*/ FacesContext.getCurrentInstance().addMessage(
                 "message_ok",
                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                 " Votre inscription c'est bien deroulé",
                 " vous pouvez vous connecte"));
		return "home";
	}
	
	
	public String searchPersonCv(){
		setPersonSearch(personActivityManager.findCvActivity(search));
		pers= getPersonSearch();
		
		return "search";
	}
	
	public String showPersonSearch(Person pers){
		System.out.println("hjsqdkffffffffffffffdjksq");
		this.setPerson(pers);
		return "person?faces-redirect=true";
	}
	
//	public String searchPerson(){
//		return "person?faces-redirect=true";
//		
//	}
}
