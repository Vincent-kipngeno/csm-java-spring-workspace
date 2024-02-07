package tech.csm.domain;

public class ProjectVO {
	
	private String projectId;
	private String projectName;
	private String pmName;
	private TechnologyVO technology;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPmName() {
		return pmName;
	}
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	public TechnologyVO getTechnology() {
		return technology;
	}
	public void setTechnology(TechnologyVO technology) {
		this.technology = technology;
	}
	
	@Override
	public String toString() {
		return "ProjectVO [projectId=" + projectId + ", projectName=" + projectName + ", pmName=" + pmName
				+ ", technology=" + technology + "]";
	}
	

}
