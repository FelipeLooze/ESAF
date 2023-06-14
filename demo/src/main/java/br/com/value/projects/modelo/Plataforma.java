package br.com.value.projects.modelo;

import java.util.List;

public class Plataforma {
    private List<User> users;

    public Plataforma(List<User> users, List<Curso> cursos) {
        this.users = users;
    }

    // getters e setters para as listas
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}