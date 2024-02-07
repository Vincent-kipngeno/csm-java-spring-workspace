package tech.csm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="village")
public class Village implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "village_id")
	private Integer villageId;
	@Column(name = "village_name")
	private String villageName;

	private Integer population;
	
	@ManyToOne
	@JoinColumn(name = "block_id")
	private Block block;
	
	@ManyToOne
	@JoinColumn(name = "panchayat_id")
	private Panchayat panchayat;
	
	@Override
	public String toString() {
		return "Village [villageId=" + villageId + ", villageName=" + villageName + ", population=" + population
				+ ", blockName=" + block.getBlockName() + ", panchayatName=" + panchayat.getPanchayatName() + "]";
	}
}
