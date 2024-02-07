package tech.csm.service;

import java.util.List;

import tech.csm.dao.PanchayatDao;
import tech.csm.dao.PanchayatDaoImpl;
import tech.csm.entity.Panchayat;

public class PanchayatServiceImpl implements PanchayatService {

	private PanchayatDao panchayatDao=new PanchayatDaoImpl();
	
	@Override
	public List<Panchayat> getPanchayatByBlockId(Integer blockId) {
		return panchayatDao.getPanchayatByBlockId(blockId);
	}

	@Override
	public Panchayat getPanchayatByPanchayatId(Integer panchayatId) {
		return panchayatDao.getPanchayatByPanchayatId(panchayatId);
	}

	@Override
	public Boolean panchayatMatchesBlock(Panchayat panchayat, Integer blockId) {
		return panchayat != null && panchayat.getBlock().getBlockId().equals(blockId);
	}
}
