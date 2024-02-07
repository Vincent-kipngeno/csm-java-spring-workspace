package tech.csm.service;

import tech.csm.dao.TechnologyDao;
import tech.csm.dao.TechnologyDaoImpl;

import java.util.ArrayList;
import java.util.List;

import tech.csm.dao.ProjectDao;
import tech.csm.dao.ProjectDaoImpl;
import tech.csm.domain.Project;
import tech.csm.domain.ProjectVO;

public class ProjectServiceImpl implements ProjectService {

	private TechnologyDao technologyDao=null;
	private ProjectDao projectDao=null;
	private TechnologyService technologyService=null;
	
	public ProjectServiceImpl() {
		technologyDao=new TechnologyDaoImpl();
		projectDao=new ProjectDaoImpl();
		technologyService = new TechnologyServiceImpl();
	}
	
	
	@Override
	public String saveProject(ProjectVO projectVO) {
		Project project=new Project();
		project.setProjectId(projectVO.getProjectId());
		project.setProjectName(projectVO.getProjectName());
		project.setPmName(projectVO.getPmName());
		project.setTechnology(technologyDao.getTechnologyById(Integer.parseInt(projectVO.getTechnology().getTechnologyId())));
		return projectDao.saveProject(project);
	}


	@Override
	public String updateProject(ProjectVO projectVO) {
		Project project=new Project();
		project.setProjectId(projectVO.getProjectId());
		project.setProjectName(projectVO.getProjectName());
		project.setPmName(projectVO.getPmName());
		project.setTechnology(technologyDao.getTechnologyById(Integer.parseInt(projectVO.getTechnology().getTechnologyId())));
		return projectDao.updateProject(project);
	}


	@Override
	public ProjectVO getProjectById(String projectId) {
		Project p=projectDao.getProjectById(projectId);
		ProjectVO projectVO=null;
		if(p!=null) {
			projectVO = new ProjectVO();
			projectVO.setProjectId(p.getProjectId());
			projectVO.setProjectName(p.getProjectName());
			projectVO.setPmName(p.getPmName());
			projectVO.setTechnology(technologyService.getTechnologyById(p.getTechnology().getTechnologyId()));
		}
		
		return projectVO;
	}


	@Override
	public List<ProjectVO> getAllProjects() {
		List<Project> projectList=projectDao.getAllProjects();
		List<ProjectVO> projectVoList=null;
		if(projectList!=null) {
			projectVoList=new ArrayList<>();
			for(Project p:projectList) {
				ProjectVO projectVO=new ProjectVO();
				projectVO.setProjectId(p.getProjectId());
				projectVO.setProjectName(p.getProjectName());
				projectVO.setPmName(p.getPmName());
				projectVO.setTechnology(technologyService.getTechnologyById(p.getTechnology().getTechnologyId()));
				projectVoList.add(projectVO);
			}
		}
		return projectVoList;
	}


	@Override
	public String deleteProjectById(String projectId) {
		return projectDao.deleteProjectById(projectId);
	}

}
