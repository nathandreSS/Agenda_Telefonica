package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.exceptions.TelefoneInvalido;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.exceptions.TelefoneVazio;

public class Telefone {

    private String telefone;

    public Telefone() {}
    public Telefone(String telefone) {

        try {
            validate(telefone);
        } catch (TelefoneVazio telefoneVazio) {
            throw new Error(telefoneVazio.getMessage());
        } catch (TelefoneInvalido telefoneInvalido) {
            throw new Error(telefoneInvalido.getMessage());
        }
        this.telefone = telefone;
    }

    public Telefone(Telefone telefone) {

        try {
            validate(telefone.getTelefone());
        } catch (TelefoneVazio telefoneVazio) {
            throw new Error(telefoneVazio.getMessage());
        } catch (TelefoneInvalido telefoneInvalido) {
            throw new Error(telefoneInvalido.getMessage());
        }
        this.telefone = telefone.getTelefone();
    }

    public boolean validate(String numero) throws TelefoneVazio, TelefoneInvalido {
        String pattern = "[(]{1}[0-9]{2}[)]{1}[0-9]{4}[-]{1}[0-9]{4}";
        if(numero == "") throw new TelefoneVazio();
        if(!numero.matches(pattern)) throw new TelefoneInvalido();
        return true;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
