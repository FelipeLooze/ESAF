package br.com.value.projects.controller.dto;

import br.com.value.projects.modelo.Curso;

public class CursoDTO {
    private String nomeCurso;
    private Long userId;

    // Construtor padrão
    public CursoDTO() {
    }

    // Construtor que aceita um objeto Curso
    public CursoDTO(Curso curso) {
        this.nomeCurso = curso.getNomeCurso();
        this.userId = curso.getUser().getId();
    }

    // getters e setters
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
