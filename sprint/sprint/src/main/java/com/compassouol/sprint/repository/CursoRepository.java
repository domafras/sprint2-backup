package com.compassouol.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compassouol.sprint.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
