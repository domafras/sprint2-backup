package com.compassouol.sprint.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.compassouol.sprint.model.Professor;
import com.compassouol.sprint.repository.ProfessorRepository;

@Service
@Transactional
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepo;
	
	public List<Professor> listAll() {
		return professorRepo.findAll();
	}
	
	public Professor save(Professor professor) {
		return professorRepo.save(professor);
	}
	
	public void deleteByIdProfessor(Long id) {
		professorRepo.deleteById(id);
	}
	
	public Professor getById(Long id) {
		return professorRepo.getById(id);
	}
}
