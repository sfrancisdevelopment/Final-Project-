package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Courses;
import beans.Marks;
import beans.Student;

public class MarksDAOImpl implements MarksDAO{

	
	public List<Marks> findAllMarks(int s_id) {
		System.out.println("MarksDAOImpl/findAllMarks");
    	SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		Student s1 = (Student) session.get(Student.class, s_id);
		@SuppressWarnings({"unchecked"})
		List<Marks> marks = session.createQuery("from Marks where student_id_s_id = "+s1.getS_id()).list();
		session.close();
		return marks;

	}//findAllMarks
	
	public Marks findMark(int m_id){
		System.out.print("MarksDAOImpl/findMark");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		Marks m = (Marks) session.get(Marks.class, m_id);
		session.close();
		return m;
	}//findMark
	
	public Student findStudent(int s_id){
		System.out.print("MarksDAOImpl/findStudent");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		Student s = (Student) session.get(Student.class, s_id);
		Hibernate.initialize(s);
		session.close();
		return s;
	}//findStudent
	
	public Courses findCourses(int c_id){
		System.out.print("MarksDAOImpl/findCourses");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		Courses c = (Courses) session.get(Courses.class, c_id);
		System.out.println(c.getCourse_name());
		session.close();
		return c;
	}//findCourse
	
	public void addMark(Marks m){
	    System.out.print("MarksDAOImpl/addMark");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.save(m);
	    session.flush();  
	    session.getTransaction().commit();
	    session.close();
	}//addMark
	
	
	public void deleteMark(Marks m){
		System.out.println("MarksDAOImpl/deletMark");
	    SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(m);
	    session.getTransaction().commit();
	    session.close();
	}//deletStudent
	
	public void updateMark(Marks m){
		System.out.println("MarksDAOImpl/updateMark");
    	SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Marks m1 = (Marks) session.load(Marks.class, m.getId());
		m1.setMark(m.getMark());
		Hibernate.initialize(m1);
        session.update(m1);
        session.getTransaction().commit();
        session.close();	
	}//updateStudent
	
	
	
}//MarksDAOImpl
