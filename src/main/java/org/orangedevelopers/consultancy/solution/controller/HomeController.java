package org.orangedevelopers.consultancy.solution.controller;
/*package org.orangedevelopers.consultancy.solution.test;

import java.util.List;

import org.orangedevelopers.consultancy.solution.entity.CurrentStudy;
import org.orangedevelopers.consultancy.solution.entity.Client;
import org.orangedevelopers.consultancy.solution.entity.EducationalDetail;
import org.orangedevelopers.consultancy.solution.entity.Language;
import org.orangedevelopers.consultancy.solution.entity.PersonalStatement;
import org.orangedevelopers.consultancy.solution.entity.ProgramOfStudy;
import org.orangedevelopers.consultancy.solution.entity.WorkExperience;
import org.orangedevelopers.consultancy.solution.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

*//**
 * Handles requests for the application home page.
 *//*
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	*//**
	 * Simply selects the home view to render by returning its name.
	 *//*
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "clientDetail";
	}
	
	@RequestMapping(value = "/saveProgramOfStudy", method = RequestMethod.GET)
	public String saveProgramOfStudy(@ModelAttribute("programOfStudy") ProgramOfStudy program) {
		System.out.println(program.getAwardingBody());
		personalDetailsService.save(program);
		return "clientDetail";
	}
	
	@RequestMapping(value = "/saveCurrentStudy", method = RequestMethod.GET)
	public String saveCurrentStudy(@ModelAttribute("currentStudy") CurrentStudy currentStudy) {
		personalDetailsService.save(currentStudy);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/savelanguageDetail", method = RequestMethod.GET)
	public String savelanguageDetail(@ModelAttribute("languageDetail") Language language) {
		personalDetailsService.save(language);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/saveEducationalDetail", method = RequestMethod.GET)
	public String saveEducationalDetail(@ModelAttribute("educationalDetail") EducationalDetail educationalDetail) {
		personalDetailsService.save(educationalDetail);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/saveWorkExperience", method = RequestMethod.GET)
	public String saveWorkExperience(@ModelAttribute("workExperience") WorkExperience workExperience) {
		personalDetailsService.save(workExperience);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/savePersonalStatement", method = RequestMethod.GET)
	public String savePersonalStatement(@ModelAttribute("personalDetail") PersonalStatement personalStatement) {
		personalDetailsService.save(personalStatement);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/saveReference", method = RequestMethod.GET)
	public <T> String saveReference(@ModelAttribute("reference") T entity) {
		personalDetailsService.save(entity);
		return "redirect:/home";
	}

	
	
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	public String getListOfStudents(Model model) {
		//personalDetailsService.save(personalStatement);
		List<Client> studentList = personalDetailsService.getAll("Client");
		model.addAttribute("studentList", studentList);
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute("test") CurrentStudy study) {
		return "redirect:/home";
	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		return "test";
	}

}
*/