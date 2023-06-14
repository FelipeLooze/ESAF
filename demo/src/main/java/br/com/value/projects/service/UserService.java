package br.com.value.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.value.projects.modelo.CPF;
import br.com.value.projects.modelo.Curso;
import br.com.value.projects.modelo.User;
import br.com.value.projects.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User cadastrarUsuario(String nome, int moeda, CPF cpf) {
        User user = new User(nome, moeda, cpf);
        return userRepository.save(user);
    }

    public User buscarUsuarioPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void adicionarMoedasAoUsuario(Long id, int valor) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.adicionaMoeda(valor);
            userRepository.save(user);
        }
    }

}