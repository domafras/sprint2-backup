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

import com.compassouol.sprint.model.Disciplina;
import com.compassouol.sprint.service.DisciplinaService;

@Controller
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
		
	@GetMapping("/disciplina")
	public String disciplina(Model model) {
		List<Disciplina> listDisciplinas = disciplinaService.listAll(); 
		model.addAttribute("listDisciplinas", listDisciplinas);
		return "disciplina";
	}
	
	@RequestMapping("/disciplina/novo")
	public String mostrarNovoDisciplina(Model model) {
		Disciplina disciplina = new Disciplina();
	    model.addAttribute("disciplina", disciplina);
	    return "disciplina/novo";
	}
	
	@RequestMapping(value = "/disciplina/save", method = RequestMethod.POST)
	public String salvarDisciplina(@ModelAttribute("disciplina") Disciplina disciplina) {
		disciplinaService.save(disciplina);
		return "redirect:/disciplina";
	}
	
	@RequestMapping(value = "/disciplina/delete/{id}")
	public String excluirDisciplina(@PathVariable(name = "id")Long id) {
		disciplinaService.deleteByIdDisciplina(id);
		return "redirect:/disciplina";
		
	}
		
	@RequestMapping(value = "/disciplina/edit/{id}")
	public ModelAndView editarDisciplina(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("disciplina/edit");
	    Disciplina disciplina = disciplinaService.getById(id);
	    mav.addObject("disciplina", disciplina);

	    return mav;
	}
}
