package tech.csm.service;

import java.util.List;

import tech.csm.entity.Panchayat;

public interface PanchayatService {

	List<Panchayat> getPanchayatByBlockId(Integer blockId);
	
	Panchayat getPanchayatByPanchayatId(Integer panchayatId);

	Boolean panchayatMatchesBlock(Panchayat panchayat, Integer blockId);

}
