package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.exceptions;

public class CepVazio extends Exception {
    @Override
    public String getMessage() {
        return "Cep vazio";
    }
}
