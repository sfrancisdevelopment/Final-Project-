package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Student;

 
public class StudentDAOImpl implements StudentDAO {
 
	public Boolean addStudent(Student student) {
		System.out.println("StudentDAOImpl/addStudent");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Boolean error=false; 
        if (session.get(Student.class, student.getS_id())==null){
            session.save(student);
        }
        else{
        	System.out.println("error should = true");
        	error=true;
        }
		session.getTransaction().commit();
		session.close();
		return error;
	}//addStudnt



	@SuppressWarnings({ "unchecked"})
	public List<Student> findAll() {
			System.out.println("StudentDAOImpl/findAll");
	    	SessionFactory sessionFactory = HibernateUti.getSessionFactory();
			Session session = sessionFactory.openSession();
			List<Student> students = session.createQuery("from Student").list();
			session.close();
			return students;
	}//findAll
	
	public Student findStudent(int id){
			System.out.println("StudentDAOImpl/findStudent");
			SessionFactory sessionFactory = HibernateUti.getSessionFactory();
			//System.out.println("StudentDAOImpl/findStudent  before openSession");
			Session session = sessionFactory.openSession();
			//System.out.println("StudentDAOImpl/findStudent  after openSession");
			Student s1 = (Student) session.load(Student.class, id);
			//System.out.println("StudentDAOImpl/findStudent  after session.load" + s1.toString());
			Hibernate.initialize(s1);
	        session.close();
	        //System.out.println("StudentDAOImpl/findStudent  after session.close");
	        return s1;
	}
	
	public void updateStudent(Student student){
			System.out.println("StudentDAOImpl/updateStudent");
	    	SessionFactory sessionFactory = HibernateUti.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Student s1 = (Student) session.load(Student.class, student.getS_id());
			s1.setF_name(student.getF_name());
			s1.setL_name(student.getL_name());
	        session.update(s1);
	        session.getTransaction().commit();
	        session.close();	
	}//updateStudent


	public void deleteStudent(int id){
			System.out.println("StudentDAOImpl/deleteStudent");
		    SessionFactory sessionFactory = HibernateUti.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Student s1 = (Student) session.load(Student.class, id);
			session.delete(s1);
		    session.getTransaction().commit();
		    session.close();
	}//deleteStudent
 
}//end of StudentDAOImpl
