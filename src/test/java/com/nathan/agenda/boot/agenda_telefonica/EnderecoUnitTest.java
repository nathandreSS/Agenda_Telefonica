package com.nathan.agenda.boot.agenda_telefonica;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.Endereco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoUnitTest {

    @Test
    void CreatingEndereco() {
        Endereco endereco = new Endereco("12345-678", 78, "Vila do Chaves");
        Assertions.assertEquals(endereco.getCep(), "12345-678");
        Assertions.assertEquals(endereco.getNumero(), 78);
        Assertions.assertEquals(endereco.getComplemento(), "Vila do Chaves");
    }

    @Test
    void CreatingEnderecoWithoutComplemento() {
        Endereco endereco = new Endereco("12345-678", 78, "");
        Assertions.assertEquals(endereco.getCep(), "12345-678");
        Assertions.assertEquals(endereco.getNumero(), 78);
        Assertions.assertEquals(endereco.getComplemento(), "");
    }

    @Test
    void ShouldThrowCepVazioErrorWhenCreatingEnderecoWithoutCep() {
        Endereco endereco = null;
        try {
            endereco = new Endereco("", 78, "");
        } catch(Error error) {
            Assertions.assertEquals("Cep vazio", error.getMessage());
        }

        Assertions.assertEquals(null, endereco);
    }

    @Test
    void ShouldThrowCepInvalidoErrorWhenCreatingEnderecoWithCepWithoutFirstDigits() {
        Endereco endereco = null;
        try {
            endereco = new Endereco("-123", 78, "");
        } catch(Error error) {
            Assertions.assertEquals("Formato de cep inválido", error.getMessage());
        }

        Assertions.assertEquals(null, endereco);
    }

    @Test
    void ShouldThrowCepInvalidoErrorWhenCreatingEnderecoWithCepWithoutHyphen() {
        Endereco endereco = null;
        try {
            endereco = new Endereco("12345678", 78, "");
        } catch(Error error) {
            Assertions.assertEquals("Formato de cep inválido", error.getMessage());
        }

        Assertions.assertEquals(null, endereco);
    }

    @Test
    void ShouldThrowCepInvalidoErrorWhenCreatingEnderecoWithCepWithoutLastDigits() {
        Endereco endereco = null;
        try {
            endereco = new Endereco("12345-", 78, "");
        } catch(Error error) {
            Assertions.assertEquals("Formato de cep inválido", error.getMessage());
        }

        Assertions.assertEquals(null, endereco);
    }
}
