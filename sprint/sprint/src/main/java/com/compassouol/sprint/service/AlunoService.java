package com.compassouol.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.sprint.model.Aluno;
import com.compassouol.sprint.repository.AlunoRepository;

@Service
@Transactional
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepo;
	
	public List<Aluno> listAll() {
		return alunoRepo.findAll();
	}
	
	public Aluno save(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public void deleteByIdAluno(Long id) {
		alunoRepo.deleteById(id);
	}
	
	public Aluno getById(Long id) {
		return alunoRepo.getById(id);
	}
}
