package com.compassouol.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.compassouol.sprint.model.Professor;
import com.compassouol.sprint.service.ProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
		
	@GetMapping("/professor")
	public String professor(Model model) {
		List<Professor> listProfessores = professorService.listAll(); 
		model.addAttribute("listProfessores", listProfessores);
		return "professor";
	}
	
	@RequestMapping("/professor/novo")
	public String mostrarNovoProfessor(Model model) {
	    Professor professor = new Professor();
	    model.addAttribute("professor", professor);
	    return "professor/novo";
	}
	
	@RequestMapping(value = "/professor/save", method = RequestMethod.POST)
	public String salvarProfessor(@ModelAttribute("professor") Professor professor) {
		professorService.save(professor);
		return "redirect:/professor";
	}
	
	@RequestMapping(value = "/professor/delete/{id}")
	public String excluirProfessor(@PathVariable(name = "id")Long id) {
		professorService.deleteByIdProfessor(id);
		return "redirect:/professor";
		
	}
		
	@RequestMapping(value = "/professor/edit/{id}")
	public ModelAndView editarProfessor(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("professor/edit");
	    Professor professor = professorService.getById(id);
	    mav.addObject("professor", professor);

	    return mav;
	}
}
