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

import com.compassouol.sprint.model.Aluno;
import com.compassouol.sprint.service.AlunoService;

@Controller
public class AlunoController {
			
	@Autowired
	private AlunoService alunoService;
		
	@GetMapping("/aluno")
	public String aluno(Model model) {
		List<Aluno> listAlunos = alunoService.listAll(); 
		model.addAttribute("listAlunos", listAlunos);
		return "aluno";
	}
	
	@RequestMapping("/aluno/novo")
	public String mostrarNovoAluno(Model model) {
	    Aluno aluno = new Aluno();
	    model.addAttribute("aluno", aluno);
	    return "aluno/novo";
	}
	
	@RequestMapping(value = "/aluno/save", method = RequestMethod.POST)
	public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
		alunoService.save(aluno);
		return "redirect:/aluno";
	}
	
	@RequestMapping(value = "/aluno/delete/{id}")
	public String excluirAluno(@PathVariable(name = "id")Long id) {
		alunoService.deleteByIdAluno(id);
		return "redirect:/aluno";
		
	}
		
	@RequestMapping(value = "/aluno/edit/{id}")
	public ModelAndView editarAluno(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("aluno/edit");
	    Aluno aluno = alunoService.getById(id);
	    mav.addObject("aluno", aluno);

	    return mav;
	}
}



