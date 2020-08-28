package com.nathan.agenda.boot.agenda_telefonica.domain.exceptions;

public class NomeObrigatorio extends Exception {
    @Override
    public String getMessage(){
        return "Nome é obrigatório para criação de um contato";
    }
}
