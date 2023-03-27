package srpingAPP.demo.dto;

import java.sql.Date;

import lombok.*;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class StudentRequest {
	private String name;
	private String group;
	private Integer age;
	private Date b_day;
	private String uid;
}
