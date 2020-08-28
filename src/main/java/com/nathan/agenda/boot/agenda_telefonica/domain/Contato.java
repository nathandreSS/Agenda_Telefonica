package com.nathan.agenda.boot.agenda_telefonica.domain;

import com.nathan.agenda.boot.agenda_telefonica.domain.exceptions.NomeObrigatorio;
import com.nathan.agenda.boot.agenda_telefonica.domain.exceptions.TelefoneObrigatorio;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email.Email;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.Endereco;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome.Nome;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.Telefone;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Contato {
    private Nome nomeObject;
    private List<Telefone> telefoneObject = new ArrayList<Telefone>();
    private Email emailObject;
    private Endereco enderecoObject;

    public Contato(Nome nome, List<Telefone> telefone, Email email, Endereco endereco) {

        try {
            validate(nome, telefone);
        } catch (NomeObrigatorio nomeObrigatorio) {
            throw new Error (nomeObrigatorio.getMessage());
        } catch (TelefoneObrigatorio telefoneObrigatorio) {
            throw new Error (telefoneObrigatorio.getMessage());
        }
        this.nomeObject = nome;
        this.telefoneObject = telefone;
        this.emailObject = email;
        this.enderecoObject = endereco;
    }

    public Contato(Contato contato) {

        try {
            validate(contato.getNomeObject(), contato.getTelefoneObject());
        } catch (NomeObrigatorio nomeObrigatorio) {
            throw new Error (nomeObrigatorio.getMessage());
        } catch (TelefoneObrigatorio telefoneObrigatorio) {
            throw new Error (telefoneObrigatorio.getMessage());
        }
        this.nomeObject = new Nome(contato.getNomeObject());

        for(int i = 0; i < contato.getTelefoneObject().size(); i ++) {

            this.telefoneObject.add(new Telefone(contato.getTelefoneObject().get(i)));
        }

        this.emailObject = new Email(contato.getEmailObject());
        this.enderecoObject = new Endereco(contato.getEnderecoObject());
    }

    public boolean validate(Nome nome, List<Telefone> telefone) throws NomeObrigatorio, TelefoneObrigatorio {
        if(nome == null) throw new NomeObrigatorio();
        if(telefone == null) throw new TelefoneObrigatorio();
        if(telefone.size() == 0) throw new TelefoneObrigatorio();

        return true;
    }
}
