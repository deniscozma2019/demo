package srpingAPP.demo.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
@Getter
@Setter
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@NotNull(message = "Name is mandatory")
	private String name;
	@NotBlank
	@NotNull(message = "Group is mandatory")
	private String group;
	private Integer age;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "b_day")
	private Date b_day;
	
	private String uid;
	
	@Override
	public String toString() {
		return "Student [id="+id+", name="+name+", group="+group+", birth day="+b_day+"]";
	}

}
