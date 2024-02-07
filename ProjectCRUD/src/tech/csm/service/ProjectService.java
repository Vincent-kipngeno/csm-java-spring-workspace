package tech.csm.service;

import java.util.List;

import tech.csm.domain.ProjectVO;

public interface ProjectService {

	String saveProject(ProjectVO projectVo);
	String updateProject(ProjectVO projectVo);
	ProjectVO getProjectById(String projectId);
	List<ProjectVO> getAllProjects();
	String deleteProjectById(String projectId);

}
