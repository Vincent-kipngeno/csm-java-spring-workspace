package tech.csm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.csm.model.City;
import tech.csm.model.State;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {

	@Query("from City c where c.state.stateId=:sId")
	List<City> getCityByStateId(Integer sId);



}
