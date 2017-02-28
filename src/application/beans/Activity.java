package application.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.openjpa.persistence.jdbc.ForeignKey;

@Entity
@Table(name = "activity")
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idActivity;

	@Temporal(TemporalType.DATE)
	//@Column(name="year", nullable = false)
	private Date year;
	
    @Enumerated(EnumType.STRING)
    @Column(name="nature", nullable = false)
	private Nature nature;
    
    @Column(name="title", nullable = false)
    @NotNull(message="le titre  ne peut pas etre vide") 
    @Size(min=2, max=50, message="le titre doit etre entre 2 à 500 caractere") 
	private String title;
    
    @Column(name="description", nullable = false)
    @NotNull(message="veuillez fournir une description") 
    @Size(min=10, max=1000, message="la description doit etre entre 10 à 1000 caractere")
	private String description;
	
    @Column(name="webAddress")
    private String webAddress;

	/*@ManyToOne (cascade =  CascadeType.MERGE)
	@JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
	private Person person;
	*/
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = false)
    @ForeignKey(name="FK_PERSON_ACTIVITY")
    private Person person;

	
	public Integer getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}