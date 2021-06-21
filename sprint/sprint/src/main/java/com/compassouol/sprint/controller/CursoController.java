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

import com.compassouol.sprint.model.Curso;
import com.compassouol.sprint.service.CursoService;

@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;
		
	@GetMapping("/curso")
	public String curso(Model model) {
		List<Curso> listCursos = cursoService.listAll(); 
		model.addAttribute("listCursos", listCursos);
		return "curso";
	}
	
	@RequestMapping("/curso/novo")
	public String mostrarNovoCurso(Model model) {
	    Curso curso = new Curso();
	    model.addAttribute("curso", curso);
	    return "curso/novo";
	}
	
	@RequestMapping(value = "/curso/save", method = RequestMethod.POST)
	public String salvarCurso(@ModelAttribute("curso") Curso curso) {
		cursoService.save(curso);
		return "redirect:/curso";
	}
	
	@RequestMapping(value = "/curso/delete/{id}")
	public String excluirCurso(@PathVariable(name = "id")Long id) {
		cursoService.deleteByIdCurso(id);
		return "redirect:/curso";
	}
		
	@RequestMapping(value = "/curso/edit/{id}")
	public ModelAndView editarCurso(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("curso/edit");
	    Curso curso = cursoService.getById(id);
	    mav.addObject("curso", curso);

	    return mav;
	}
}
