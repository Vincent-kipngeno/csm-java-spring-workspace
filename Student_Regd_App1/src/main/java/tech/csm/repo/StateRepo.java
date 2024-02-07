package tech.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.model.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {

}
