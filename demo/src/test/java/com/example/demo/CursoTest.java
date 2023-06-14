package com.example.demo;

import org.junit.jupiter.api.Test;

import br.com.value.projects.modelo.CPF;
import br.com.value.projects.modelo.Curso;
import br.com.value.projects.modelo.User;

import static org.junit.jupiter.api.Assertions.*;

public class CursoTest {

	@Test
	public void testGetId() {
	    Curso curso = new Curso("Curso de Matemática");
	    assertNull(curso.getId());
	}

	@Test
	public void testGetNomeCurso() {
	    Curso curso = new Curso("Curso de Inglês");
	    assertEquals("Curso de Inglês", curso.getNomeCurso());
	}

	@Test
	public void testSetNomeCurso() {
	    Curso curso = new Curso();
	    curso.setNomeCurso("Curso de Programação");
	    assertEquals("Curso de Programação", curso.getNomeCurso());
	}

	@Test
	public void testGetUser() {
	    Curso curso = new Curso("Curso de História");
	    assertNull(curso.getUser());
	}

	@Test
	public void testSetUser() {
	    Curso curso = new Curso();
	    User user = new User("John Doe", 1, new CPF("12345678901"));
	    curso.setUser(user);
	    assertEquals(user, curso.getUser());
	}
}