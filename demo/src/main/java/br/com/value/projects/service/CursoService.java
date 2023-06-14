package br.com.value.projects.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.value.projects.controller.dto.CursoDTO;
import br.com.value.projects.modelo.Curso;
import br.com.value.projects.modelo.User;
import br.com.value.projects.repository.CursoRepository;
import br.com.value.projects.repository.UserRepository;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final UserRepository userRepository;

    public CursoService(CursoRepository cursoRepository, UserRepository userRepository) {
        this.cursoRepository = cursoRepository;
        this.userRepository = userRepository;
    }

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id) {
        java.util.Optional<Curso> cursoOptional = cursoRepository.findById(id);
        return cursoOptional.orElse(null);
    }

    public Curso createCurso(CursoDTO cursoDTO) {
        String nomeCurso = cursoDTO.getNomeCurso();
        Long userId = cursoDTO.getUserId();

        java.util.Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Curso curso = new Curso(nomeCurso);
        curso.setUser(user);

        return cursoRepository.save(curso);
    }

    public boolean updateCurso(Long id, CursoDTO cursoDTO) {
        java.util.Optional<Curso> cursoOptional = cursoRepository.findById(id);
        Curso existingCurso = cursoOptional.orElse(null);

        if (existingCurso == null) {
            return false;
        }

        String nomeCurso = cursoDTO.getNomeCurso();
        Long userId = cursoDTO.getUserId();

        java.util.Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        existingCurso.setNomeCurso(nomeCurso);
        existingCurso.setUser(user);

        cursoRepository.save(existingCurso);
        return true;
    }

    public boolean deleteCurso(Long id) {
        java.util.Optional<Curso> cursoOptional = cursoRepository.findById(id);
        Curso existingCurso = cursoOptional.orElse(null);

        if (existingCurso == null) {
            return false;
        }

        cursoRepository.delete(existingCurso);
        return true;
    }
}
