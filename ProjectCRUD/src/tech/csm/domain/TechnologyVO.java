package tech.csm.domain;

public class TechnologyVO {
	
	private String technologyId;
	private String technologyName;
	
	public String getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(String technologyId) {
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
		return "TechnologyVO [technologyId=" + technologyId + ", technologyName=" + technologyName + "]";
	}
}
