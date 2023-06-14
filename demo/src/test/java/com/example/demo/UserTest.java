package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.value.projects.modelo.CPF;
import br.com.value.projects.modelo.Curso;
import br.com.value.projects.modelo.User;

@SpringBootTest
class UserTest {
	
	@Test
	public void adicionaMoedasAoUsuario() {
		User nelson = new User("Nelson", 0, new CPF("12345678901"));
		Curso matematica = new Curso("Matematica");
		Curso historia = new Curso("Historia");
		Curso fisica = new Curso("Fisica");
		Curso quimica = new Curso("quimica");
		Curso biologia = new Curso("biologia");
		Curso portugues = new Curso("portugues");
		Curso ingles = new Curso("ingles");
		Curso artes = new Curso("artes");
		Curso ed_fisica = new Curso("educacao fisica");
		Curso musica = new Curso("musica");
		Curso informatica = new Curso("informatica");
		Curso geografia = new Curso("geografia");
		
		nelson.adicionaCurso(matematica);
		nelson.adicionaCurso(historia);
		nelson.adicionaCurso(fisica);
		nelson.adicionaCurso(quimica);
		nelson.adicionaCurso(biologia);
		nelson.adicionaCurso(portugues);
		nelson.adicionaCurso(ingles);
		nelson.adicionaCurso(artes);
		nelson.adicionaCurso(ed_fisica);
		nelson.adicionaCurso(musica);
		nelson.adicionaCurso(informatica);
		nelson.adicionaCurso(geografia);
		
		nelson.adicionaMoeda(3);
		
		assertEquals(1, nelson.getStatus(), 0.0001);
		assertEquals(12, nelson.getCursos().size(), 0.0001);
		assertEquals(3, nelson.getMoeda(), 0.0001);
	}

}