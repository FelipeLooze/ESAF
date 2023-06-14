package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.value.projects.modelo.CPF;

public class CPFTest {

    @Test
    public void testValidCPF() {
        String cpfNumber = "12345678909";
        CPF cpf = new CPF(cpfNumber);

        Assertions.assertEquals(cpfNumber, cpf.getNumero());
        Assertions.assertTrue(cpf.isValid());
    }

    @Test
    public void testInvalidCPF() {
        String cpfNumber = "123456789";
        CPF cpf = new CPF(cpfNumber);

        Assertions.assertEquals(cpfNumber, cpf.getNumero());
        Assertions.assertFalse(cpf.isValid());
    }
}
