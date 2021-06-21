package com.compassouol.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.sprint.model.Curso;
import com.compassouol.sprint.repository.CursoRepository;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository cursoRepo;
	
	public List<Curso> listAll() {
		return cursoRepo.findAll();
	}
	
	public Curso save(Curso curso) {
		return cursoRepo.save(curso);
	}
	
	public void deleteByIdCurso(Long id) {
		cursoRepo.deleteById(id);
	}
	
	public Curso getById(Long id) {
		return cursoRepo.getById(id);
	}
}
