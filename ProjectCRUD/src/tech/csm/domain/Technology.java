package tech.csm.domain;

import java.io.Serializable;

public class Technology implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -397544006740629664L;
	private Integer technologyId;
	private String technologyName;
	
	public Integer getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechnologyName() {
		return technologyName;
	}
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	@Override
	public String toString() {
		return "Technology [technologyId=" + technologyId + ", technologyName=" + technologyName + "]";
	}
	
}
