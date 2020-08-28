package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.telefone.exceptions;

public class TelefoneVazio extends Exception {
    @Override
    public String getMessage() {
        return "Telefone vazio";
    }
}
