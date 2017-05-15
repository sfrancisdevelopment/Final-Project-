package dao;

import java.util.List;

import beans.Courses;
import beans.Marks;
import beans.Student;


public interface MarksDAO {
	List<Marks> findAllMarks(int s_id);
	Marks findMark(int m_id);
	Student findStudent(int s_id);
	Courses findCourses(int c_id);
	void addMark(Marks m);
	void deleteMark(Marks m);
	void updateMark(Marks m);
}
