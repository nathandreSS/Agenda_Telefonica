package com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome;

import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome.exceptions.NomeVazio;
import com.nathan.agenda.boot.agenda_telefonica.domain.valueObjects.nome.exceptions.PrimeiraLetraMinuscula;

public class Nome {
    private String firstName;
    private String lastName;

    public Nome() {}
    public Nome(String primeiroNome, String sobrenome){

        try {
            this.validate(primeiroNome, sobrenome);
        } catch (PrimeiraLetraMinuscula primeiraLetraMinuscula) {
            throw new Error(primeiraLetraMinuscula.getMessage());
        } catch (NomeVazio nomeVazio) {
            throw new Error(nomeVazio.getMessage());
        }
        this.firstName = primeiroNome;
        this.lastName = sobrenome;
    }

    public Nome(Nome nome){

        try {
            this.validate(nome.getFirstName(), nome.getLastName());
        } catch (PrimeiraLetraMinuscula primeiraLetraMinuscula) {
            throw new Error(primeiraLetraMinuscula.getMessage());
        } catch (NomeVazio nomeVazio) {
            throw new Error(nomeVazio.getMessage());
        }
        this.firstName = nome.getFirstName();
        this.lastName = nome.getLastName();
    }

    public boolean validate(String primeiroNome, String sobrenome ) throws PrimeiraLetraMinuscula, NomeVazio {

        String pattern = "^[A-ZÀ-Ú][a-zà-ú]*$";
        if(primeiroNome == "") throw new NomeVazio();
        if(!primeiroNome.matches(pattern)) throw new PrimeiraLetraMinuscula();
        if(!sobrenome.matches(pattern) && sobrenome != "") throw new PrimeiraLetraMinuscula();

        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.firstName = primeiroNome;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSobrenome(String sobrenome) {
        this.lastName = sobrenome;
    }
}
