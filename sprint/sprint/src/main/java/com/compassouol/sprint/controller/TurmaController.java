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

import com.compassouol.sprint.model.Turma;
import com.compassouol.sprint.service.TurmaService;

@Controller
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
		
	@GetMapping("/turma")
	public String turma(Model model) {
		List<Turma> listTurmas = turmaService.listAll(); 
		model.addAttribute("listTurmas", listTurmas);
		return "turma";
	}
	
	@RequestMapping("/turma/novo")
	public String mostrarNovoTurma(Model model) {
	    Turma turma = new Turma();
	    model.addAttribute("turma", turma);
	    return "turma/novo";
	}
	
	@RequestMapping(value = "/turma/save", method = RequestMethod.POST)
	public String salvarTurma(@ModelAttribute("turma") Turma turma) {
		turmaService.save(turma);
		return "redirect:/turma";
	}
	
	@RequestMapping(value = "/turma/delete/{id}")
	public String excluirTurma(@PathVariable(name = "id")Long id) {
		turmaService.deleteByIdTurma(id);
		return "redirect:/turma";
		
	}
		
	@RequestMapping(value = "/turma/edit/{id}")
	public ModelAndView editarTurma(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("turma/edit");
	    Turma turma = turmaService.getById(id);
	    mav.addObject("turma", turma);

	    return mav;
	}
}
