package controller;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/students")
public class studentController  {

		@RequestMapping(value = "/add_page" ,method = RequestMethod.GET)
	    public String AddStudentPage(Map<String, Object> model) {  
				Student student = new Student();
				System.out.println("studentController/add_page");
				model.put("student", student);
				return "addStudent";
	    }//add student page
	     
	
	  @RequestMapping(value = "/add" ,method = RequestMethod.POST)
	    public ModelAndView AddStudent(@ModelAttribute("student") Student student,
	            Map<String, Object> model) {
	         	System.out.println("studentController/add");
				StudentDAO sDAO = new StudentDAOImpl();
				Boolean errormsg = sDAO.addStudent(student);
				System.out.println(errormsg);
			
				if (errormsg == true) {
					System.out.println("entered into error msg");
					String errormessage=("Student ID already taken, please try again. ");
					model.put("Error", errormessage);
					return new ModelAndView ("addStudent");
				}//if student id taken
				else{
				List<Student> students = sDAO.findAll();
				return new ModelAndView ("listAll", "Students", students);
				}//if add successful
	  }//if add student
	
	  
		@RequestMapping (value = "/list" , method = RequestMethod.GET) 
		public ModelAndView ListStudents(HttpServletRequest request, HttpServletResponse response){
			StudentDAO sDAO = new StudentDAOImpl();
			List<Student> students = sDAO.findAll();
			System.out.println("studentsController/list");
			return new ModelAndView ("listAll", "Students", students);
		} // if list all
		
		@RequestMapping(value = "/edit/{s_id}" ,method = RequestMethod.GET)
	    public String EditStudentPage(@PathVariable("s_id") int s_id, Map<String, Object> model) {  
				System.out.println("studentController/edit/{"+s_id+"}");
				StudentDAO sDAO = new StudentDAOImpl();
				Student student=sDAO.findStudent(s_id);
				System.out.println(student.toString());
				model.put("student", student);
				return "editStudent";
	    }//edit student page

		@RequestMapping(value = "/update" , method = RequestMethod.POST)
		public ModelAndView UpdateStudent(@ModelAttribute("student") Student student, Map<String, Object> model){
			StudentDAO sDAO = new StudentDAOImpl();
			sDAO.updateStudent(student);
			List<Student> students = sDAO.findAll();
			return new ModelAndView ("listAll", "Students", students);
		} // update student

		@RequestMapping(value = "/delete/{s_id}" , method = RequestMethod.GET)
		public ModelAndView DeleteStudent(@PathVariable("s_id") int s_id, HttpServletRequest request, HttpServletResponse response) {
			StudentDAO sDAO = new StudentDAOImpl();
			sDAO.deleteStudent(s_id);
			List<Student> students = sDAO.findAll();
			return new ModelAndView ("listAll", "Students", students);
		} // delete student

}
