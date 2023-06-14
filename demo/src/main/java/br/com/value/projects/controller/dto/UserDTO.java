package br.com.value.projects.controller.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.value.projects.modelo.Curso;
import br.com.value.projects.modelo.User;

public class UserDTO {
    private Long id;
    private String nome;
    private int moeda;
    private int status;
    private List<Long> cursos;
    private String cpf;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.moeda = user.getMoeda();
        this.status = user.getStatus();
        this.cursos = extractCursoIds(user.getCursos());
        this.cpf = user.getCpf().getNumero();
    }

    private List<Long> extractCursoIds(List<Curso> cursos) {
        List<Long> cursoIds = new ArrayList<>();
        for (Curso curso : cursos) {
            cursoIds.add(curso.getId());
        }
        return cursoIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setMoeda(int moeda) {
        this.moeda = moeda;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Long> getCursos() {
        return cursos;
    }

    public void setCursos(List<Long> cursos) {
        this.cursos = cursos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
