package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.apache.log4j.Logger;

@Entity
public class Mission implements Serializable {
	
	private static final Logger l = Logger.getLogger(Mission.class);

	private static final long serialVersionUID = -5369734855993305723L;

	// Auto Increment 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	@ManyToOne
	private Departement departement;
	
	// Mission est la cardinalité la plus faible, donc mappedBy ici :hj
	
	@OneToMany(mappedBy="mission")
	private  List<Timesheet> timesheets;
	
	public Mission() {
		super();
	}

	public Mission(String name, String description){
		this.name = name;
		this.description = description;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	

}
