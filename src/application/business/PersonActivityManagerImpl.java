package application.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import application.beans.Activity;
import application.beans.Person;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonActivityManagerImpl {

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
	
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		
		if(em.find(Person.class, p.getIdPerson())==null){
			em.persist(p);
		}else{
			em.merge(p);
		}
		
	}
	
	public Person showPerson(int idPerson) {
		// TODO Auto-generated method stub
		return em.find(Person.class, idPerson);
	}

	
	public Activity showActivity(int idActivity) {
		// TODO Auto-generated method stub
		return em.find(Activity.class, idActivity);
	}


	public List<Activity> listActivityByPerson(Person p) {
		// TODO Auto-generated method stub
		Query query=null;
		try{
		query = em.createQuery("select a from Activity a where a.person.idPerson = :id");
		query.setParameter("id", p.getIdPerson());
		}catch(NoResultException ex){
			return null;
		}
		
		return (List <Activity>) query.getResultList();
	}

	public List<Person> findCvActivity(String word){
//		 Query query = em.createQuery(
//				"select Distinct p from Activity a, Person p "
//			   + "where a.title like '%"+word+"%' and p.idPerson= a.person.idPerson ");
//		 
		 Query query = em.createQuery(
					"select Distinct p from Activity a, Person p "
				   + "where p.lastName like '%" +word+"%'"
				   + "or p.firstName like '%"+ word+"%'"
				   + "or a.title like '%"+word+"%'"
				   		+ "and p.idPerson= a.person.idPerson");
		 
		 /*query.setParameter("word1", word);
		 query.setParameter("word2", word);
		 query.setParameter("word3", word);*/
		 
		 List<Person> listPerson = query.getResultList();
		return listPerson;
	}
	
//	public List<Person> findPersonByName(String name){
//		// TODO Auto-generated method stub
//		Query query=null;
//		try{
//		query = em.createQuery("select p from Person p where p.lastName  LIKE '%"+
//					name+"%'  OR p.firstName LIKE '%"+name+"%'");
//		}catch(NoResultException ex){
//			return null;
//		}
//		
//		return (List <Person>) query.getResultList();
//	}
	
//	public List<Activity> findActivityByTitle(String title) {
//		// TODO Auto-generated method stub
//		Query query=null;
//		try{
//		query = em.createQuery("select a from activity a  where a.title LIKE '%"+
//		title+"%'");
//		}catch(NoResultException ex){
//			return null;
//		}
//		
//		return (List <Activity>) query.getResultList();
//	}

	
//	public List<Person> findPersonByActivity(String title) {
//		// TODO Auto-generated method stub
//		Query query=null;
//		try{
//		query = em.createQuery("select a  from Activity a, Person  where Person.idPerson = a.person"
//				+ "AND a.title LIKE '%"+title+"%'");
//		}catch(NoResultException ex){
//			return null;
//		}
//		
//		return (List <Person>) query.getResultList();
//	}

}
