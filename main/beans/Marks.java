package beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class Marks implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Student student_id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Courses course_id;
	private int mark;
	
	
	public Student getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Student student_id) {
		this.student_id = student_id;
	}
	public Courses getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Courses course_id) {
		this.course_id = course_id;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	
	
	
	
	

}
