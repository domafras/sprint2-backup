package com.compassouol.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.compassouol.sprint.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
