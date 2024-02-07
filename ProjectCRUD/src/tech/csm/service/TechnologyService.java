package tech.csm.service;

import java.util.List;

import tech.csm.domain.TechnologyVO;

public interface TechnologyService {

	List<TechnologyVO> getAllTechnologies();
	TechnologyVO getTechnologyById(Integer technologyId);
	TechnologyVO getTechnologyByName(String technologyName);
}
