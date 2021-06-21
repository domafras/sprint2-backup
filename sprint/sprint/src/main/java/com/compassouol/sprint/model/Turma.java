package com.compassouol.sprint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turma {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "curso.codigoCurso")
	private Curso codigoCurso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Curso getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(Curso codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	
	
}
