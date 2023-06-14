package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.value.projects.modelo.CPF;
import br.com.value.projects.modelo.User;
import br.com.value.projects.repository.UserRepository;
import br.com.value.projects.service.UserService;

import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarUsuario() {
        // Mock do UserRepository
        User savedUser = new User("John Doe", 100, new CPF("123456789"));
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Chamar o método cadastrarUsuario
        User user = userService.cadastrarUsuario("John Doe", 100, new CPF("123456789"));

        // Verificar se o usuário foi salvo corretamente
        assertNotNull(user);
        assertEquals(savedUser.getNome(), user.getNome());
        assertEquals(savedUser.getMoeda(), user.getMoeda());
        assertEquals(savedUser.getCpf(), user.getCpf());

        // Verificar se o método save do UserRepository foi chamado
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testBuscarUsuarioPorId_UsuarioExistente() {
        // Mock do UserRepository
        User existingUser = new User("John Doe", 100, new CPF("123456789"));
        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));

        // Chamar o método buscarUsuarioPorId
        User user = userService.buscarUsuarioPorId(1L);

        // Verificar se o usuário foi encontrado corretamente
        assertNotNull(user);
        assertEquals(existingUser.getNome(), user.getNome());
        assertEquals(existingUser.getMoeda(), user.getMoeda());
        assertEquals(existingUser.getCpf(), user.getCpf());

        // Verificar se o método findById do UserRepository foi chamado
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testBuscarUsuarioPorId_UsuarioNaoExistente() {
        // Mock do UserRepository
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Chamar o método buscarUsuarioPorId
        User user = userService.buscarUsuarioPorId(1L);

        // Verificar se o usuário não foi encontrado
        assertNull(user);

        // Verificar se o método findById do UserRepository foi chamado
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testAdicionarMoedasAoUsuario_UsuarioExistente() {
        // Mock do UserRepository
        User existingUser = new User("John Doe", 100, new CPF("123456789"));
        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(existingUser);

        // Chamar o método adicionarMoedasAoUsuario
        userService.adicionarMoedasAoUsuario(1L, 50);

        // Verificar se as moedas foram adicionadas corretamente
        assertEquals(150, existingUser.getMoeda());

        // Verificar se o método findById do UserRepository foi chamado
        verify(userRepository, times(1)).findById(1L);

        // Verificar se o método save do UserRepository foi chamado
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    public void testAdicionarMoedasAoUsuario_UsuarioNaoExistente() {
        // Mock do UserRepository
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Chamar o método adicionarMoedasAoUsuario
        userService.adicionarMoedasAoUsuario(1L, 50);

        // Verificar se o método findById do UserRepository foi chamado
        verify(userRepository, times(1)).findById(1L);

        // Verificar se o método save do UserRepository não foi chamado
        verify(userRepository, never()).save(any(User.class));
    }

}