package com.compassouol.sprint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.sprint.model.Disciplina;
import com.compassouol.sprint.repository.DisciplinaRepository;

@Service
@Transactional
public class DisciplinaService {

		@Autowired
		private DisciplinaRepository disciplinaRepo;
		
		public List<Disciplina> listAll() {
			return disciplinaRepo.findAll();
		}
		
		public Disciplina save(Disciplina disciplina) {
			return disciplinaRepo.save(disciplina);
		}
		
		public void deleteByIdDisciplina(Long id) {
			disciplinaRepo.deleteById(id);
		}
		
		public Disciplina getById(Long id) {
			return disciplinaRepo.getById(id);
		}
}
