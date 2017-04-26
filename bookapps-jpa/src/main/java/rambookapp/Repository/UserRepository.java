package rambookapp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rambookapp.model.Student;

public interface UserRepository extends JpaRepository<Student, Long>{
	public Student findByEmailAndPassword(String emailId, String password);	
}