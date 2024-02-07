package tech.csm.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "t_state_master")
@Getter @Setter
public class State implements Serializable {

	@Id
	@Column(name = "state_id")
	private Integer stateId;
	@Column(name = "state_name")
	private String stateName;
	
	@OneToMany(mappedBy = "state")
	private List<City> cities;
	
}
