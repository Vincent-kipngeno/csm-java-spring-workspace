package tech.csm.dao;

import java.util.List;

import tech.csm.domain.Project;

public interface ProjectDao {

	String saveProject(Project project);
	String updateProject(Project project);
	Project getProjectById(String projectId);
	List<Project> getAllProjects();
	String deleteProjectById(String projectId);

}
