package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email.exceptions;

public class EmailInvalido extends Exception {
    @Override
    public String getMessage() {
        return "Formato de email inválido";
    }

}
