package tech.csm.service;

import java.util.List;

import tech.csm.dao.VillageDao;
import tech.csm.dao.VillageDaoImpl;
import tech.csm.entity.Village;

public class VillageServiceImpl implements VillageService {
 private static VillageDao villageDao = new VillageDaoImpl();
	
	@Override
	public String addVillage(Village village) {
		return villageDao.createVillage(village);
	}

	@Override
	public List<Village> getAllVillages() {
		return villageDao.getAllVillages();
	}

}
