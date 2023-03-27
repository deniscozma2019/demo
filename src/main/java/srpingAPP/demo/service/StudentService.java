package srpingAPP.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srpingAPP.demo.dto.StudentRequest;
import srpingAPP.demo.model.Student;
import srpingAPP.demo.schemes.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository repoStudent;
	
	public Student saveStudent(StudentRequest studentRequest) {
		System.out.println(studentRequest.getName());
		studentRequest.getName();
		StudentRequest.build(saveStudent((StudentRequest) getAllStudents()));
		//Student student = new Student(studentRequest.get)
		return null;
		//return repoStudent.save(student);
	}
	
	public List<Student> getAllStudents(){
		return repoStudent.findAll();
	}
}
