package tech.csm.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_branch_master")
@Getter @Setter
public class Branch implements Serializable {

	@Id
	@Column(name = "branch_id")
	private Integer branchId;
	@Column(name = "branch_name")
	private String branchName;
	
}
