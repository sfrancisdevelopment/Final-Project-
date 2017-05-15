package dao;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import beans.Courses;
import beans.Marks;
import beans.Student;

public class HibernateUti {
    private static SessionFactory sessionFactory;

    private HibernateUti() {
    }
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Courses.class);
            configuration.addAnnotatedClass(Marks.class);
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}