package br.com.value.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.value.projects.controller.dto.CursoDTO;
import br.com.value.projects.modelo.Curso;
import br.com.value.projects.service.CursoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursos() {
        List<Curso> cursos = cursoService.getAllCursos();
        List<CursoDTO> cursoDTOs = cursos.stream()
                .map(CursoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cursoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getCursoById(@PathVariable("id") Long id) {
        Curso curso = cursoService.getCursoById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        CursoDTO cursoDTO = new CursoDTO(curso);
        return ResponseEntity.ok(cursoDTO);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoDTO) {
        Curso curso = cursoService.createCurso(cursoDTO);
        CursoDTO responseDTO = new CursoDTO(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable("id") Long id, @RequestBody CursoDTO cursoDTO) {
        boolean isUpdated = cursoService.updateCurso(id, cursoDTO);
        if (!isUpdated) {
            return ResponseEntity.notFound().build();
        }
        Curso curso = cursoService.getCursoById(id);
        CursoDTO responseDTO = new CursoDTO(curso);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable("id") Long id) {
        boolean isDeleted = cursoService.deleteCurso(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
