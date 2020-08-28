package com.nathan.agenda.boot.agenda_telefonica;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.Telefone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TelefoneUnitTest {

    @Test
    void CreatingPhone() {
        Telefone phone = new Telefone("(99)9999-9999");
        Assertions.assertEquals("(99)9999-9999", phone.getTelefone());
    }

    @Test
    void ShouldThrowTelefoneVazioError() {
        Telefone phone = null;
        try {
            phone = new Telefone("");
        } catch (Error error) {
            Assertions.assertEquals("Telefone vazio", error.getMessage());
        }
        Assertions.assertEquals(null, phone);
    }

    @Test
    void ShouldThrowTelefoneInvalidoErrorWhenCreatingTelefoneWithoutParentheses() {
        Telefone phone = null;
        try {
            phone = new Telefone("999999-9999");
        } catch (Error error) {
            Assertions.assertEquals("Formato de telefone inválido", error.getMessage());
        }
        Assertions.assertEquals(null, phone);
    }

    @Test
    void ShouldThrowTelefoneInvalidoErrorWhenCreatingTelefoneWithoutDDD() {
        Telefone phone = null;
        try {
            phone = new Telefone("()9999-9999");
        } catch (Error error) {
            Assertions.assertEquals("Formato de telefone inválido", error.getMessage());
        }
        Assertions.assertEquals(null, phone);
    }

    @Test
    void ShouldThrowTelefoneInvalidoErrorWhenCreatingTelefoneWithoutFirstDigits() {
        Telefone phone = null;
        try {
            phone = new Telefone("(99)-9999");
        } catch (Error error) {
            Assertions.assertEquals("Formato de telefone inválido", error.getMessage());
        }
        Assertions.assertEquals(null, phone);
    }

    @Test
    void ShouldThrowTelefoneInvalidoErrorWhenCreatingTelefoneWithoutHyphen() {
        Telefone phone = null;
        try {
            phone = new Telefone("(99)99999999");
        } catch (Error error) {
            Assertions.assertEquals("Formato de telefone inválido", error.getMessage());
        }
        Assertions.assertEquals(null, phone);
    }

    @Test
    void ShouldThrowTelefoneInvalidoErrorWhenCreatingTelefoneWithoutLastDigits() {
        Telefone phone = null;
        try {
            phone = new Telefone("(99)9999-");
        } catch (Error error) {
            Assertions.assertEquals("Formato de telefone inválido", error.getMessage());
        }
        Assertions.assertEquals(null, phone);
    }
}
