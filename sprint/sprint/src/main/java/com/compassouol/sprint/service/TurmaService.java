package com.compassouol.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.sprint.model.Turma;
import com.compassouol.sprint.repository.TurmaRepository;

@Service
@Transactional
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepo;
	
	public List<Turma> listAll() {
		return turmaRepo.findAll();
	}
	
	public Turma save(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	public void deleteByIdTurma(Long id) {
		turmaRepo.deleteById(id);
	}
	
	public Turma getById(Long id) {
		return turmaRepo.getById(id);
	}
}