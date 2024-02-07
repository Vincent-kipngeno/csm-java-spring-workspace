package tech.csm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tech.csm.domain.Project;
import tech.csm.domain.Technology;
import tech.csm.util.DBUtil;

public class ProjectDaoImpl implements ProjectDao {

	private Connection con;
	private TechnologyDao technologyDao=null;

	public ProjectDaoImpl() {
		con = DBUtil.getConnection();
		technologyDao = new TechnologyDaoImpl();
	}
	
	
	@Override
	public String saveProject(Project project) {
		final String seQuery="insert into project_master(Projectid, Projectname, PMName, technologyid) values(?,?,?,?)";
		int c;
		String res=null;
		try {
			PreparedStatement ps = con.prepareStatement(seQuery,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, project.getProjectId());
			ps.setString(2, project.getProjectName());
			ps.setString(3, project.getPmName());
			ps.setInt(4, project.getTechnology().getTechnologyId());
			c= ps.executeUpdate();
			res=c+" record saved with id : "+project.getProjectId();
			ps.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return res;
	}


	@Override
	public String updateProject(Project project) {
		final String updateQuery = "update project_master set Projectname=?, PMName=?, technologyid=? where Projectid=?";
		int updatedRows;
		String result = null;

		try {
		    PreparedStatement ps = con.prepareStatement(updateQuery);
		    ps.setString(1, project.getProjectName());
		    ps.setString(2, project.getPmName());
		    ps.setInt(3, project.getTechnology().getTechnologyId());
		    ps.setString(4, project.getProjectId());

		    updatedRows = ps.executeUpdate();

		    if (updatedRows > 0) {
		        result = updatedRows + " record updated for id: " + project.getProjectId();
		    } else {
		        result = "No records updated. Project with id: " + project.getProjectId() + " not found.";
		    }

		    ps.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		}

		return result;

	}


	@Override
	public Project getProjectById(String projectId) {
		final String getByIdQuery = "select Projectid, Projectname, PMName, TechnologyId from project_master where Projectid=?";
		Project project = null;

		try {
		    PreparedStatement ps = con.prepareStatement(getByIdQuery);
		    ps.setString(1, projectId);  // Assuming projectId is the parameter to find by
		    ResultSet rs = ps.executeQuery();
		    
		    if (rs.next()) {
		        project = new Project();
		        project.setProjectId(rs.getString(1));
		        project.setProjectName(rs.getString(2));
		        project.setPmName(rs.getString(3));
		        project.setTechnology(technologyDao.getTechnologyById(rs.getInt(4)));
		    }

		    rs.close();
		    ps.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		}

		return project;

	}


	@Override
	public List<Project> getAllProjects() {
		final String getAllProjectsQuery = "select Projectid, Projectname, PMName, TechnologyId from project_master";
		List<Project> projectList = null;

		try {
		    PreparedStatement ps = con.prepareStatement(getAllProjectsQuery);
		    ResultSet rs = ps.executeQuery();

		    if (rs.next()) {
		        projectList = new ArrayList<>();
		        do {
		            Project project = new Project();
		            project.setProjectId(rs.getString(1));
		            project.setProjectName(rs.getString(2));
		            project.setPmName(rs.getString(3));
		            project.setTechnology(technologyDao.getTechnologyById(rs.getInt(4)));

		            projectList.add(project);
		        } while (rs.next());
		    }

		    rs.close();
		    ps.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		}

		return projectList;

	}


	@Override
	public String deleteProjectById(String projectId) {
		final String deleteQuery = "DELETE FROM project_master WHERE Projectid=?";
		int deletedRows;
		String result = null;

	    try {
	        PreparedStatement ps = con.prepareStatement(deleteQuery);
	        ps.setString(1, projectId);
	        
	        deletedRows = ps.executeUpdate();
	        if (deletedRows > 0) {
		        result = deletedRows + " record deleted for id: " + projectId;
		    } else {
		        result = "No records deleted. Project with id: " + projectId + " not found.";
		    }

	        ps.close();
	    } catch (SQLException se) {
	        se.printStackTrace();
	    }

	    return result;
	}

}
