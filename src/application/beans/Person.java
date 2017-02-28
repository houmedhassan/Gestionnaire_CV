package application.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person", uniqueConstraints={@UniqueConstraint(columnNames = {"mail"})})
public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPerson")
	private Integer idPerson;
	
	@Column(name="lastName", nullable = false)
	@NotNull(message="le nom n'est pas etre vide") 
	@Size(min=2, max=50, message="le nom doit etre entre 2 � 50 caractere") 
	private String lastName;
	
	@Column(name="firstName", nullable = false)
	@NotNull(message="le nom n'est pas etre vide") 
	@Size(min=2, max=50, message="le nom doit etre entre 2 � 50 caractere") 
	private String firstName;
	
	@Column(name="mail", nullable = false, unique=true)
	@NotNull(message="l'email ne peut pas etre vide") 
	@Pattern(regexp="([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message="votre email n'est pas correcte")
	private String mail;
	
	@Column(name="webSite", nullable = false)
	private String webSite;

	@Temporal(TemporalType.DATE)
	/*@Column(name="birthday", nullable = false)
	 * @NotNull
	*/private Date birthday;
	
	@Column(name="password", nullable = false)
	@NotNull(message="le mot de passe est obligatoire")
	private String password;
	
	@Transient
	//@NotNull(message="la confirmation de mot de passe est obligatoire")
	private String confirmationpassword;

	@OneToMany(mappedBy = "person", cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinTable(name = "activity")
	private List<Activity> activities;
	
	
	/**
	 * 
	 * @return
	 */
	public Integer getIdPerson() {
		return idPerson;
	}
	/**
	 * 
	 * @param idPerson
	 */

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	

}