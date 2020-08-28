package com.nathan.agenda.boot.agenda_telefonica;

import com.nathan.agenda.boot.agenda_telefonica.domain.Contato;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email.Email;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.Endereco;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome.Nome;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.Telefone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ContatoUnitTest {

    private Nome nome = new Nome("John", "Doe");
    private List<Telefone> telefones = Arrays.asList(new Telefone("(99)9999-9999"), new Telefone("(88)8888-8888"));
    private Email email = new Email("JohnDoe@dominio.com");
    private Endereco endereco = new Endereco("12345-678", 78, "Vila do Chaves");

    @Test
    void CreatingContato() {
        Contato contato = new Contato(this.nome, this.telefones, this.email, this.endereco);
        Assertions.assertEquals(this.nome, contato.getNomeObject());
        Assertions.assertEquals(this.telefones, contato.getTelefoneObject());
        Assertions.assertEquals(this.email, contato.getEmailObject());
        Assertions.assertEquals(this.endereco, contato.getEnderecoObject());
    }
    @Test
    void CreatingContatoWithoutEmail() {
        Contato contato = new Contato(this.nome, this.telefones, null, this.endereco);
        Assertions.assertEquals(this.nome, contato.getNomeObject());
        Assertions.assertEquals(this.telefones, contato.getTelefoneObject());
        Assertions.assertEquals(null, contato.getEmailObject());
        Assertions.assertEquals(this.endereco, contato.getEnderecoObject());
    }
    @Test
    void CreatingContatoWithoutEndereco() {
        Contato contato = new Contato(this.nome, this.telefones, this.email, null);
        Assertions.assertEquals(this.nome, contato.getNomeObject());
        Assertions.assertEquals(this.telefones, contato.getTelefoneObject());
        Assertions.assertEquals(this.email, contato.getEmailObject());
        Assertions.assertEquals(null, contato.getEnderecoObject());
    }
    @Test
    void ShouldThrowNomeObrigatorioErrorWhenCreatingContatoWithoutNome() {
        Contato contato = null;
        try {
            contato = new Contato(null, this.telefones, this.email, this.endereco);
        } catch(Error error) {
            Assertions.assertEquals("Nome é obrigatório para criação de um contato", error.getMessage());
        }
        Assertions.assertEquals(null, contato);
    }
    @Test
    void ShouldThrowTelefoneObrigatorioErrorWhenCreatingContatoWithoutTelefone() {
        Contato contato = null;
        try {
            contato = new Contato(this.nome, null, this.email, this.endereco);
        } catch(Error error) {
            Assertions.assertEquals("Telefone é obrigatório para criação de um contato", error.getMessage());
        }
        Assertions.assertEquals(null, contato);
    }

}
