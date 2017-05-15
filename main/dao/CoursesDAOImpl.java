package dao;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import beans.Courses;


public class CoursesDAOImpl implements CoursesDAO{
	
	
	public void addCourse(Courses c) throws PersistenceException {
		System.out.println("CoursesDAOImpl/addCourse");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        session.save(c);	        
        session.getTransaction().commit();
        session.close();
	}//addCourse


	@SuppressWarnings({ "unchecked"})
	public List<Courses> findAll() {
		System.out.println("CoursesDAOImpl/findAll");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Courses> courses = session.createQuery("from Courses").list();
		
		 courses = session.createCriteria(Courses.class)
			    .addOrder( Order.asc("course_id") )
			    .list();
		
		session.close();
		return courses;
	}//findAll

	public Courses findCourse(int id){
		System.out.println("CoursesDAOImpl/findCourse");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		Courses c = (Courses) session.load(Courses.class, id);
		Hibernate.initialize(c);
        session.close();
        return c;
	}//findCourse
	
	
	public void updateCourse(Courses c){
		System.out.println("CoursesDAOImpl/updateCourse");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Courses c1 = (Courses) session.load(Courses.class, c.getCourse_id());
		c1.setCourse_id(c.getCourse_id());
		c1.setCourse_name(c.getCourse_name());
        session.update(c1);
        session.getTransaction().commit();
        session.close();
	}//updateCourse
	
	
	
	public void editCourse(String course_name, int course_id) {
		System.out.println("CoursesDAOImpl/editCourse");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Courses c1 = (Courses) session.load(Courses.class, course_id);
		c1.setCourse_name(course_name);
        session.update(c1);
        session.getTransaction().commit();
        session.close();
	}//editCourse

	public void delete(int id) {
		System.out.println("CoursesDAOImpl/delete");
		SessionFactory sessionFactory = HibernateUti.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Courses c = (Courses) session.load(Courses.class, id);
        session.delete(c);
        session.getTransaction().commit();
        session.close();
		
	}
	
    
    
    
 
}
