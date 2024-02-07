package tech.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.model.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Integer> {

}
