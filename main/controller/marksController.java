package controller;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.hibernate.ObjectNotFoundException;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.*;
import dao.*;

@Controller
@RequestMapping("/marks")
public class marksController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Courses.class, "course_id", new PropertyEditorSupport() {
			@Override
			public String getAsText()
			{
				Courses course = (Courses) getValue();
				return course.getCourse_name() + " ";
			}
			@Override
			public void setAsText(String text)
			{
				CoursesDAO cDAO = new CoursesDAOImpl();
				try { setValue(cDAO.findCourse(Integer.parseInt(text))); }
				catch(ObjectNotFoundException ex) { ex.printStackTrace(); }
				catch(ParseException ex2) { ex2.printStackTrace(); }
			}
		});
	}
	
	@RequestMapping(value = "/list/{s_id}", method = RequestMethod.GET)
	public String ListMarks(@PathVariable("s_id") int s_id, Map<String, Object> model){
		System.out.println("marksController/list/{"+s_id+"}");
		MarksDAO mDAO = new MarksDAOImpl();
		System.out.println("marksController/list/{"+s_id+"}" + "afterMDAO");
		List<Marks> m = mDAO.findAllMarks(s_id); 
		System.out.println("marksController/list/{"+s_id+"}" + "after findallmarks");
		Student s1=mDAO.findStudent(s_id);
		System.out.println("marksController/list/{"+s_id+"}" +"find students");
		model.put("Student", s1);
        model.put("Marks", m);
        return ("listAllMarks");
            
		}// if list all 
	
	@RequestMapping(value = "/add_page/{s_id}", method = RequestMethod.GET)
	public String AddMarksPage(@PathVariable("s_id") int s_id, Map<String, Object> model){
			System.out.println("marksController/add_page");
			Marks marks = new Marks();
			MarksDAO mDAO = new MarksDAOImpl();
			CoursesDAO cDAO = new CoursesDAOImpl();
			Student s1=mDAO.findStudent(s_id);
			marks.setStudent_id(s1);
			marks.setCourse_id(new Courses());
			List<Courses> courses = cDAO.findAll(); 
			model.put("Student", s1);	
			model.put("Courses", courses);
			model.put("marks", marks);
			return "addMarks";
		} // add mark page
	
	@RequestMapping(value = "/add_mark/{s_id}" , method = RequestMethod.POST)
	public String AddMark(@PathVariable("s_id") int s_id, @ModelAttribute("marks") Marks marks, Map<String, Object> model) {
         	System.out.println("marksController/add_mark");
         
			MarksDAO mDAO = new MarksDAOImpl();
			Student s = mDAO.findStudent(s_id);
			mDAO.addMark(marks);
			List<Marks> m = mDAO.findAllMarks(s_id);
			model.put("Marks", m);
			model.put("Student", s);
			return "listAllMarks";
	}//add mark
	
	
	@RequestMapping(value = "/delete/{m_id}" , method = RequestMethod.GET)
	public String DeleteMark(@PathVariable("m_id") int m_id, Map<String, Object> model) {
		MarksDAO mDAO = new MarksDAOImpl();
		Marks m1 = mDAO.findMark(m_id);
		Student s = m1.getStudent_id();
		mDAO.deleteMark(m1);
		List<Marks> m = mDAO.findAllMarks(s.getS_id());
		model.put("Student", s);
		model.put("Marks", m);
		return "listAllMarks" ;
	} // delete student
	
	@RequestMapping(value = "/edit/{m_id}" ,method = RequestMethod.GET)
    public String EditMarksPage(@PathVariable("m_id") int m_id, Map<String, Object> model) {  
			System.out.println("makrsController/edit/{"+m_id+"}");
			MarksDAO mDAO = new MarksDAOImpl();
			Marks m1 = mDAO.findMark(m_id);
			Student s = m1.getStudent_id();
			model.put("Student", s);
			model.put("marks", m1);
			return "editMark";
    }//go to edit page
	
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String UpdateMark(@ModelAttribute("marks") Marks marks, Map<String, Object> model){
		System.out.println("makrsController/update");
		MarksDAO mDAO = new MarksDAOImpl();
		System.out.println("makrsController/update..... after mDAO");
		Student s = marks.getStudent_id();
		System.out.println("makrsController/update..... after s");
		mDAO.updateMark(marks);
		System.out.println("makrsController/update..... after update Mark");
		List<Marks> m = mDAO.findAllMarks(s.getS_id());
		
		for(Marks marks1 : m) {
            System.out.println(marks1.getMark());
        }
		model.put("Student", s );
		model.put("Marks", m);
		return "listAllMarks";
	} // update student
	
}
