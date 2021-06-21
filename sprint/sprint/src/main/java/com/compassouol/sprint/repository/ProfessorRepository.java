package com.compassouol.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.compassouol.sprint.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
