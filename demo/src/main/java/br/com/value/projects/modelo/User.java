package br.com.value.projects.modelo;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private int moeda;
    private int status; // 1 - Premium | 0 - Normal

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos = new ArrayList<>();

    @Embedded
    private CPF cpf;

    public User() {
    }

    public User(String nome, int moeda, CPF cpf) {
        this.nome = nome;
        this.moeda = moeda;
        this.cpf = cpf;
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void adicionaCurso(Curso curso) {
        cursos.add(curso);
        curso.setUser(this);
        verificaStatus();
    }

    public void removeCurso(Curso curso) {
        cursos.remove(curso);
        curso.setUser(null);
        verificaStatus();
    }

    private void verificaStatus() {
        this.status = cursos.size() >= 12 ? 1 : 0;
    }

    public void adicionaMoeda(int valor) {
        this.moeda += valor;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
