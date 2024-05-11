package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String question_title;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correct_answer;
	private String diffculty_level;
	private String categeory;
	public Object getOption4() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getQustionTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getOption1() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getOption2() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getOption3() {
		// TODO Auto-generated method stub
		return null;
	}
	

		
	
}
