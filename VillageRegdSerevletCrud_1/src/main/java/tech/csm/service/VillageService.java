package tech.csm.service;

import java.util.List;

import tech.csm.entity.Village;

public interface VillageService {

	String saveVillage(Village v);

	List<Village> getAllVillages();

	List<Village> getAllVillagesByBlockAndPopulation(int bId, int pop);

	List<Village> getAllVillagesByPopulation(int pop);

	List<Village> getAllVillagesByBlock(int bId);

}
