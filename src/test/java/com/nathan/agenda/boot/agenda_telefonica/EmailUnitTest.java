package com.nathan.agenda.boot.agenda_telefonica;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailUnitTest {

    @Test
    void CreatingEmail(){
        Email email = new Email("JohnDoe@dominio.com");
        Assertions.assertEquals( "JohnDoe@dominio.com",email.getEmail());
    }

    @Test
    void ShouldThrowEmailVazioErrorWhenCreatingAnEmptyEmail() {
        Email email = null;
        try {
            email = new Email("");
        }catch(Error error){
            Assertions.assertEquals("Email vazio", error.getMessage());
            }
        Assertions.assertEquals(null, email);
    }
    @Test
    void ShouldThrowEmailInvalidoErrorWhenCreatingEmailWithoutAtChar(){
        Email email = null;
        try {
            email = new Email("JohnDoedominio.com");
        }catch(Error error){
            Assertions.assertEquals("Formato de email inválido", error.getMessage());
        }
        Assertions.assertEquals(null, email);
    }

    @Test
    void ShouldThrowEmailInvalidoErrorWhenCreatingEmailWithoutDomain(){
        Email email = null;
        try {
            email = new Email("JohnDoe@.com");
        }catch(Error error){
            Assertions.assertEquals("Formato de email inválido", error.getMessage());
        }
        Assertions.assertEquals(null, email);
    }

    @Test
    void ShouldThrowEmailInvalidoErrorWhenCreatingEmailWithoutDotCom(){
        Email email = null;
        try {
            email = new Email("JohnDoe@dominio");
        }catch(Error error){
            Assertions.assertEquals("Formato de email inválido", error.getMessage());
        }
        Assertions.assertEquals(null, email);
    }

    @Test
    void ShouldThrowEmailInvalidoErrorWhenCreatingEmailWithoutUsername(){
        Email email = null;
        try {
            email = new Email("@dominio.com");
        }catch(Error error){
            Assertions.assertEquals("Formato de email inválido", error.getMessage());
        }
        Assertions.assertEquals(null, email);
    }
}
