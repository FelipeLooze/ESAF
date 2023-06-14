package br.com.value.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.value.projects.modelo.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	List<Curso> findByNomeCurso(String nomeCurso);
}