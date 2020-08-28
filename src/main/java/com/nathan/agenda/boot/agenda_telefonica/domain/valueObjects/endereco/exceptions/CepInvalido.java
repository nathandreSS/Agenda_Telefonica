package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.endereco.exceptions;

public class CepInvalido extends Exception {
    @Override
    public String getMessage() {
        return "Formato de cep inválido";
    }
}
