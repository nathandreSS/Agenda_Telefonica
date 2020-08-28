package com.nathan.agenda.boot.agenda_telefonica.domain.exceptions;

public class TelefoneObrigatorio extends Exception {
    @Override
    public String getMessage() {
        return "Telefone é obrigatório para criação de um contato";
    }
}
