package tech.csm.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.csm.model.Branch;
import tech.csm.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findByName(String string);

	List<Student> findByNameAndEmail(String string, String string2);

	List<Student> findByNameOrEmail(String string, String string2);

	List<Student> findByBranch(Branch b);

	List<Student> findByCgpaIn(Collection<Double> cgpaList);

	List<Student> findByYearOfAddmissionOrderByCgpa(Integer yp);

	@Query("from Student s where s.yearOfAddmission=:yr Order By s.cgpa desc")
	List<Student> getAllOrderByCgpa(Integer yr);
	
	@Query("from Student s where s.cgpa in (:yr1, :yr2)")
	List<Student> getAllByCgpaIn(Double yr1, Double yr2);
	
	
}
