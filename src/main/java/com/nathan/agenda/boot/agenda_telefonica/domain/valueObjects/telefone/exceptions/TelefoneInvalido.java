package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.exceptions;

public class TelefoneInvalido extends Exception {

    @Override
    public String getMessage() {
        return "Formato de telefone inválido";
    }
}
