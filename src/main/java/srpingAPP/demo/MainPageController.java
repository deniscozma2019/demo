package srpingAPP.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import srpingAPP.demo.dto.StudentRequest;
import srpingAPP.demo.model.Student;
import srpingAPP.demo.schemes.StudentRepository;
import srpingAPP.demo.service.StudentService;

@RestController
public class MainPageController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/index")
	public String welcome(Model model) {
		System.out.print("index view");
		model.addAttribute("message", "Hello world!");
		return "homepage";
	}
	
	//@GetMapping("/student")
	//public List<Student> student(Model model) {
	//	List<Student> students = studentRepo.findAll();
		//model.addAttribute("allStudents", students );
	//	return students;
	//}
	
	@GetMapping("/student")
	public String student(Model model){
		Iterable<Student> students = studentRepo.findAll();
		model.addAttribute("allStudents", students );
		return "student";
	}


	@PostMapping("/student")
	public ResponseEntity<Student> addStudent( @RequestBody @Valid StudentRequest request) {
		//Student student = new Student();
		//student.setName(name);
		//student.setGroup(group);
		//studentRepo.save(student);
		service.saveStudent(request);
		//System.out.println(name + " "+ group);
		return null;
		//return new ResponseEntity<>(service.saveStudent(request), HttpStatus.CREATED)
		//String sql = "INSERT INTO students (name, \"group\") VALUES ('"+ name + "', '" + group + "')";
		//jdbcTemplate.update(sql);
	}
	
	@PutMapping("/student")
	public void putStudent(@RequestParam("id") int id, @RequestParam("name") String name) {
			Student student = studentRepo.findById(id).get(); 
			student.setName(name); 
			// ...set rest
			//studentRepo.save(student);
		
	}

	@DeleteMapping("/student")
	public void deleteStudent(@RequestParam("id") int id) {
		studentRepo.deleteById(id);
	}
}
