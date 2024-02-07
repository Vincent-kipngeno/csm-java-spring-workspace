package tech.csm.service;

import java.util.List;

import tech.csm.dao.VillageDao;
import tech.csm.dao.VillageDaoImpl;
import tech.csm.entity.Village;

public class VillageServiceImpl implements VillageService {
 
	private VillageDao  villageDao;
	public VillageServiceImpl() {
		villageDao=new VillageDaoImpl();
	}
	@Override
	public String saveVillage(Village v) {
		
		return villageDao.saveVillage(v);
	}
	@Override
	public List<Village> getAllVillages() {
		
		return villageDao.getAllVillages();
	}
	@Override
	public List<Village> getAllVillagesByBlockAndPopulation(int bId, int pop) {
		return villageDao.getAllVillagesByBlockAndPopulation(bId, pop);
	}
	@Override
	public List<Village> getAllVillagesByPopulation(int pop) {
		return villageDao.getAllVillagesByPopulation(pop);
	}
	@Override
	public List<Village> getAllVillagesByBlock(int bId) {
		return villageDao.getAllVillagesByBlock(bId);
	}

}
