package application.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import application.beans.Activity;
import application.beans.Person;
import application.business.PersonActivityManagerImpl;
import application.business.ProfilManagerImpl;

@ManagedBean(name="userConnect")
@SessionScoped
public class ProfilManagerController {

	private static final long serialVersionUID = 1L;
	
	@EJB
	ProfilManagerImpl profilManagerImpl;
	
	@EJB 
	PersonActivityManagerImpl personActivityImpl;
	
	
	Person person = new Person();
	
	Activity activity = new Activity();
	
	private List<Activity> activities = new ArrayList<Activity>();
	
	
	
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}



	private String mail;
	private String password;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
			activity = new Activity();
	        setPerson(profilManagerImpl.loginPerson(mail, password));
	        if (person!=null) {
	        	//person = personActivityImpl.showPerson(person.getIdPerson());
	        	activities = personActivityImpl.listActivityByPerson(person);
	        	person.setActivities(activities);
	            return "showPerson?faces-redirect=true";
	        } else {
	            FacesContext.getCurrentInstance().addMessage(
	                    "msg",
	                    new FacesMessage(FacesMessage.SEVERITY_WARN,
	                    " Login Invalide!!!",
	                    "veuillez reessaiyer!"));
	            return "home";
	        }
	}
	 
	public String logout(){
		 person=profilManagerImpl.logout();
		 activities= null;
		 return "home?faces-redirect=true";
	}
	public Person show(){
		return this.personActivityImpl.showPerson(person.getIdPerson());
	}
	public String showPerson(){
		activity = new Activity();
		 if(person==null){
			 FacesContext.getCurrentInstance().addMessage(
	                    "home_message",
	                    new FacesMessage(FacesMessage.SEVERITY_WARN,
	                    "Veuillez vous connecter", "aucune session n'est active"));
	            return "home";
		 }else{
			 person = personActivityImpl.showPerson(person.getIdPerson());
			 return "showPerson?faces-redirect=true"; 
		 }
	}
	 
	public String editPerson(){
		
		if(person==null){
			 FacesContext.getCurrentInstance().addMessage(
	                    "home_message",
	                    new FacesMessage(FacesMessage.SEVERITY_WARN,
	                    "Veuillez vous connecter", "aucune session n'est active"));
	            return "home";
		 }else{
		 personActivityImpl.addPerson(person);
		 return "showPerson?faces-redirect=true"; 
		 }
	}
	public String editActivity(Activity activity){
		this.activity= activity;
		return "addActivity?faces-redirect=true";
	}
	
	public String saveActivity(){
		 if(person==null){
			 FacesContext.getCurrentInstance().addMessage(
	                    "home_message",
	                    new FacesMessage(FacesMessage.SEVERITY_WARN,
	                    "Veuillez vous connecter", "aucune session n'est active"));
	            return "home";
		 }else{
			 activity.setPerson(person);
			 //activities.add(activity);
			 profilManagerImpl.addActivity(activity);
			 activity = new Activity();
			 
			 return "showPerson?faces-redirect=true";
		 }
	}
//	public String deleteActivity(Activity activity){
//		
//		profilManagerImpl.deleteActivity(activity);
//		return "showPerson?faces-redirect=true";
//	}
	
}
