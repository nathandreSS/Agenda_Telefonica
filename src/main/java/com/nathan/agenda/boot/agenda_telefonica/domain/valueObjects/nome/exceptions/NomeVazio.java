package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome.exceptions;

public class NomeVazio extends Exception{
    @Override
    public String getMessage() {
        return "Nome está vazio";
    }
}
