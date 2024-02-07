package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import tech.csm.dao.TechnologyDao;
import tech.csm.dao.TechnologyDaoImpl;
import tech.csm.domain.Technology;
import tech.csm.domain.TechnologyVO;
import tech.csm.domain.Project;

public class TechnologyServiceImpl implements TechnologyService {

	private TechnologyDao technologyDao=null;
	public TechnologyServiceImpl() {
		technologyDao=new TechnologyDaoImpl();
	}
	
	@Override
	public List<TechnologyVO> getAllTechnologies() {
		List<Technology> technologyList=technologyDao.getAllTechnologies();
		List<TechnologyVO> technologyVoList=null;
		if(technologyList!=null) {
			technologyVoList=new ArrayList<>();
			for(Technology x:technologyList) {
				TechnologyVO technologyVo=new TechnologyVO();
				technologyVo.setTechnologyId(x.getTechnologyId().toString());
				technologyVo.setTechnologyName(x.getTechnologyName());
				technologyVoList.add(technologyVo);
			}
		}
		return technologyVoList;
	}

	@Override
	public TechnologyVO getTechnologyById(Integer technologyId) {
		Technology t=technologyDao.getTechnologyById(technologyId);
		TechnologyVO technologyVO=null;
		if(t!=null) {
			technologyVO=new TechnologyVO();
			technologyVO.setTechnologyId(t.getTechnologyId().toString());
			technologyVO.setTechnologyName(t.getTechnologyName());
		}
		
		return technologyVO;
	}
	
	@Override
	public TechnologyVO getTechnologyByName(String technologyName) {
		Technology t=technologyDao.getTechnologyByName(technologyName);
		TechnologyVO technologyVO=null;
		if(t!=null) {
			technologyVO=new TechnologyVO();
			technologyVO.setTechnologyId(t.getTechnologyId().toString());
			technologyVO.setTechnologyName(t.getTechnologyName());
		}
		
		return technologyVO;
	}

}
