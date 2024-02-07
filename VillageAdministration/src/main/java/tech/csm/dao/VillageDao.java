package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Village;

public interface VillageDao {

	String createVillage(Village village);

	List<Village> getAllVillages();

}
