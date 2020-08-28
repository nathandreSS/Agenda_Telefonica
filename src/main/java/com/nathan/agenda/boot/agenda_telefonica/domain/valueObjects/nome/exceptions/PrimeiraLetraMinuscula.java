package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome.exceptions;

public class PrimeiraLetraMinuscula extends Exception {
    @Override
    public String getMessage() {
        return "Nome e/ou sobrenome começando com letra minúscula";
    }
}
