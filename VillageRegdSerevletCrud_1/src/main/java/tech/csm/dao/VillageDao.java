package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Village;

public interface VillageDao {

	String saveVillage(Village v);

	List<Village> getAllVillages();

	List<Village> getAllVillagesByBlockAndPopulation(int bId, int pop);

	List<Village> getAllVillagesByPopulation(int pop);

	List<Village> getAllVillagesByBlock(int bId);

}
