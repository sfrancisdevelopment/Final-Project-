package beans;
import java.io.Serializable;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="student")
public class Student implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String f_name;
    private String l_name;
    @Id
	private int s_id;
    @OneToMany(mappedBy = "student_id", fetch = FetchType.EAGER, orphanRemoval = true)
	private Collection<Marks> marks;
	
	
	public Collection<Marks> getMarks() {
		return marks;
	}
	public void setMarks(Collection<Marks> marks) {
		this.marks = marks;
	}
 
	   
		public String getF_name() {
			return f_name;
		}
		public void setF_name(String f_name) {
			this.f_name = f_name;
		}
		public String getL_name() {
			return l_name;
		}
		public void setL_name(String l_name) {
			this.l_name = l_name;
		}
		public int getS_id() {
			return s_id;
		}
		public void setS_id(int s_id) {
			this.s_id = s_id;
		}
		/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "courses", cascade=CascadeType.ALL)
		public Set<Classes> getCourses() {
			return courses;
		}
		public void setCourses(Set<Classes> courses) {
			this.courses = courses;
		}*/
		@Override
		public String toString() {
			return "Student [f_name=" + f_name + ", l_name=" + l_name + ", s_id=" + s_id + "]";
		}
		

		
    
    
    
}
