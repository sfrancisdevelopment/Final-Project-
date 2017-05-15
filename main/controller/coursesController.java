package controller;


import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.*;
import dao.*;

@Controller
@RequestMapping( value = "/courses")
public class coursesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		@RequestMapping( value = "/list" , method=RequestMethod.GET)
		public ModelAndView ListCourses(){
			CoursesDAO cDAO = new CoursesDAOImpl();
			List<Courses> courses = cDAO.findAll(); 
            return new ModelAndView("listAllCourses", "Courses" , courses);
		}//list courses 
		
		@RequestMapping(value = "/edit/{course_id}", method =RequestMethod.GET)
		public String EditCourse(@PathVariable("course_id") int course_id, Map<String, Object> model){
			System.out.println("coursesController/edit/{"+course_id+"}");
			
			CoursesDAO cDAO=new CoursesDAOImpl();
			Courses courses=cDAO.findCourse(course_id);
			System.out.println(courses.toString());
			model.put("courses", courses);
			return "editCourses";
		} // if edit course
		
		@RequestMapping(value = "/delete/{course_id}", method = RequestMethod.GET)
		public ModelAndView DeleteCourse(@PathVariable("course_id") int course_id, HttpServletRequest request, HttpServletResponse response){
			CoursesDAO cDAO = new CoursesDAOImpl();
			cDAO.delete(course_id);
			List<Courses> courses = cDAO.findAll();
			return new ModelAndView("listAllCourses", "Courses" , courses);
		}//delete student 

		@RequestMapping(value = "/update" , method = RequestMethod.POST)
		public ModelAndView UpdateCourse(@ModelAttribute("courses") Courses c1, Map<String, Object> model){
			System.out.println("coursesController/update");
			CoursesDAO cDAO = new CoursesDAOImpl();
			cDAO.updateCourse(c1);
			List<Courses> courses = cDAO.findAll();
			return new ModelAndView ("listAllCourses", "Courses", courses);
		} // update course
	
		@RequestMapping(value = "/add" , method = RequestMethod.POST)
		public ModelAndView AddCourse(@ModelAttribute("courses") Courses c, Map<String, Object> model) {
	         	System.out.println("coursesController/add");
	         	
				CoursesDAO cDAO = new CoursesDAOImpl();
				cDAO.addCourse(c);
				List<Courses> courses = cDAO.findAll();
				return new ModelAndView ("listAllCourses", "Courses", courses);
	  }//add course
	
		@RequestMapping(value = "/add_page" ,method = RequestMethod.GET)
	    public String AddCoursePage(Map<String, Object> model) {  
				System.out.println("coursesController/add_page");
				
				Courses course = new Courses();
				model.put("courses", course);
				return "addCourse";
	    }//add course page
	
}