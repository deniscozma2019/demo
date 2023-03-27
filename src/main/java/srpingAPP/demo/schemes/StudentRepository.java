package srpingAPP.demo.schemes;

import org.springframework.data.jpa.repository.JpaRepository;

import srpingAPP.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
