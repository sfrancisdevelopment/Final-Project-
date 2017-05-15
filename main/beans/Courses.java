package beans;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity 
@Table ( name = "courses")
public class Courses implements Serializable {
	    
		private static final long serialVersionUID = 1L;
			
		 	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int course_id;
		 	@Column(unique=true)
		 	private String course_name;
		 	@OneToMany(mappedBy = "course_id", fetch = FetchType.EAGER, orphanRemoval = true)
		    private Collection<Marks> marks;
			
		 	
		 	
		 	
			
			public Collection<Marks> getMarks() {
				return marks;
			}
			public void setMarks(Collection<Marks> marks) {
				this.marks = marks;
			}
			public String getCourse_name() {
				return course_name;
			}
			public void setCourse_name(String course_name) {
				this.course_name = course_name;
			}
			public int getCourse_id() {
				return course_id;
			}
			public void setCourse_id(int course_id) {
				this.course_id = course_id;
			}
			@Override
			public String toString() {
				return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", marks=" + marks + "]";
			}
			
			
		   
}
