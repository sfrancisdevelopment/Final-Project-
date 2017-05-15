package dao;

import java.util.List;
import beans.Student;

public interface StudentDAO {
	Boolean addStudent(Student student);
	List<Student> findAll();
	void deleteStudent(int id);	
	Student findStudent(int id);
	void updateStudent(Student student);
}
