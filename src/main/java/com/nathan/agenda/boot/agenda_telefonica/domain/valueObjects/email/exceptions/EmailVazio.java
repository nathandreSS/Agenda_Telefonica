package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.email.exceptions;

public class EmailVazio extends Exception {
    @Override
    public String getMessage() {
        return "Email vazio";
    }
}
