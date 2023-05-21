package com.facens.facens_learn.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.facens.facens_learn.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{	
	
}
