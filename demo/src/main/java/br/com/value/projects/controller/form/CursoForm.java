package br.com.value.projects.controller.form;

public class CursoForm {
    private String nomeCurso;
    private Long userId;

    public CursoForm() {
    }

    public CursoForm(String nomeCurso, Long userId) {
        this.nomeCurso = nomeCurso;
        this.userId = userId;
    }

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
