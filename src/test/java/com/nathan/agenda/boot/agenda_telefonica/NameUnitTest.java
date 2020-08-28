package com.nathan.agenda.boot.agenda_telefonica;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome.Nome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class NameUnitTest {

    @Test
    void CreatingName() {
        Nome nome = new Nome("John", "Doe");
        Assertions.assertEquals(nome.getFirstName(), "John");
        Assertions.assertEquals(nome.getLastName(), "Doe");
    }

    @Test
    void CreatingNameWithoutLastName() {
        Nome nome = new Nome("John", "");
        Assertions.assertEquals(nome.getFirstName(), "John");
        Assertions.assertEquals(nome.getLastName(), "");
    }

    @Test
    void CreatingNameWithAccent() {
        Nome nome = new Nome("Jôóhn", "Dõe");
        Assertions.assertEquals(nome.getFirstName(), "Jôóhn");
        Assertions.assertEquals(nome.getLastName(), "Dõe");
    }

    @Test
    void CreatingNameWhenFirstNameAndLastNameStartsWithAccent() {
        Nome nome = new Nome("Íris", "Ôlga");
        Assertions.assertEquals(nome.getFirstName(), "Íris");
        Assertions.assertEquals(nome.getLastName(), "Ôlga");
    }
    @Test
    void ShouldThrowNomeVazioErrorWhenFirstNameIsEmpty() {
        Nome nome = null;
        try {
            nome = new Nome("", "Doe");
        } catch (Error error) {
            Assertions.assertEquals( "Nome está vazio", error.getMessage());
        }
        Assertions.assertEquals(null, nome);
    }

    @Test
    void ShouldThrowPrimeiraLetraMinusculaErrorWhenFirstNameStartsWithLowerCase() {
        Nome nome = null;
        try {
            nome = new Nome("John", "doe");
        } catch (Error error) {
            Assertions.assertEquals( "Nome e/ou sobrenome começando com letra minúscula", error.getMessage());
        }
        Assertions.assertEquals(null, nome);
    }

    @Test
    void ShouldThrowPrimeiraLetraMinusculaErrorWhenLastNameStartsWithLowerCase() {
        Nome nome = null;
        try {
            nome = new Nome("Nathan", "andré");
        } catch (Error error) {
            Assertions.assertEquals( "Nome e/ou sobrenome começando com letra minúscula", error.getMessage());
        }
        Assertions.assertEquals(null, nome);
    }
}
