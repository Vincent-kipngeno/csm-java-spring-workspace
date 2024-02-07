package tech.csm.dao;

import java.util.List;

import tech.csm.domain.Technology;

public interface TechnologyDao {

	List<Technology> getAllTechnologies();

	Technology getTechnologyById(Integer technologyId);
	
	Technology getTechnologyByName(String technologyName);

}
