package application.business;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ApplicationException;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import application.beans.Activity;
import application.beans.Person;

/**
 * 
 * @author Houmed HASSAN MOHAMED, Abdourahim HAMOUD MANLID
 *
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
@ApplicationException(rollback = true)
public class ProfilManagerImpl{

	private Person user = new Person();
	
	public Person getUser() {
		return user;
	}
	public void setUser(Person user) {
		this.user = user;
	}
	@PersistenceContext(unitName = "app-cv")
	EntityManager em;
	@PostConstruct()
	public void debut() {
		System.out.println("Starting " + this);
	}
	@PreDestroy
	public void fin() {
		System.out.println("Stopping " + this);
	}
	
	
	public Person loginPerson(String mail, String password) {
		// TODO Auto-generated method stub
		Query query=null;
			try{
				query= em.createQuery("SELECT p FROM Person p WHERE p.mail='"+mail+"' and p.password='"+password+"'");
				user = (Person) query.getSingleResult();
				this.setUser(user);

			}catch(NoResultException ex){
				return null;
			}
		return user;
	}

	public Person logout(){
		this.setUser(null);
		return user;
	}

	
	public void deleteProfil(Person p) {
		// TODO Auto-generated method stub
		em.remove(p);
	}
	
	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		if(em.find(Activity.class, activity.getIdActivity())==null){
//			activity.setPerson(user);
			em.persist(activity);
		}else{
			em.merge(activity);
		}
	}


	public void deleteActivity(Activity activity) {
		// TODO Auto-generated method stub
		em.remove(activity);
	}
}
