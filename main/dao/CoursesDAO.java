package dao;

import java.util.List;

import beans.Courses;;

public interface CoursesDAO {
	
	void addCourse(Courses c) throws javax.persistence.PersistenceException;
	List<Courses> findAll();
	void editCourse(String course_name, int course_id);
	void delete(int id);
	Courses findCourse(int id);
	void updateCourse(Courses c1);
	
}
