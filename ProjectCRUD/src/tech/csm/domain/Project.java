package tech.csm.domain;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6329839193298198317L;
	private String projectId;
	private String projectName;
	private String pmName;
	private Technology technology;
	
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
	public Technology getTechnology() {
		return technology;
	}
	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", pmName=" + pmName
				+ ", technology=" + technology + "]";
	}	
}
